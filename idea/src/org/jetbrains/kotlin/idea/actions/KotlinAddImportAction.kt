/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.actions

import com.intellij.codeInsight.daemon.QuickFixBundle
import com.intellij.codeInsight.daemon.impl.ShowAutoImportPass
import com.intellij.codeInsight.daemon.impl.actions.AddImportAction
import com.intellij.codeInsight.hint.HintManager
import com.intellij.codeInsight.hint.QuestionAction
import com.intellij.ide.util.DefaultPsiElementCellRenderer
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.module.ModuleUtilCore
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.popup.PopupStep
import com.intellij.openapi.ui.popup.util.BaseListPopupStep
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.statistics.StatisticsManager
import com.intellij.psi.util.ProximityLocation
import com.intellij.psi.util.proximity.PsiProximityComparator
import com.intellij.ui.popup.list.ListPopupImpl
import com.intellij.ui.popup.list.PopupListElementRenderer
import org.jetbrains.kotlin.builtins.KotlinBuiltIns
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor
import org.jetbrains.kotlin.descriptors.PackageViewDescriptor
import org.jetbrains.kotlin.idea.KotlinBundle
import org.jetbrains.kotlin.idea.KotlinDescriptorIconProvider
import org.jetbrains.kotlin.idea.caches.resolve.resolveImportReference
import org.jetbrains.kotlin.idea.codeInsight.DescriptorToSourceUtilsIde
import org.jetbrains.kotlin.idea.core.ImportableFqNameClassifier
import org.jetbrains.kotlin.idea.imports.importableFqName
import org.jetbrains.kotlin.idea.references.KtSimpleNameReference
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.idea.references.resolveMainReferenceToDescriptors
import org.jetbrains.kotlin.idea.util.ImportInsertHelper
import org.jetbrains.kotlin.idea.util.application.executeWriteCommand
import org.jetbrains.kotlin.js.resolve.diagnostics.findPsi
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.isOneSegmentFQN
import org.jetbrains.kotlin.name.parentOrNull
import org.jetbrains.kotlin.psi.KtElement
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtSimpleNameExpression
import java.awt.BorderLayout
import javax.swing.JPanel
import javax.swing.ListCellRenderer

internal fun createSingleImportAction(
    project: Project,
    editor: Editor,
    element: KtElement,
    fqNames: Collection<FqName>
): KotlinAddImportAction {
    val file = element.containingKtFile
    val prioritizer = Prioritizer(element.containingKtFile)
    val variants = fqNames.mapNotNull { fqName ->
        val sameFqNameDescriptors = file.resolveImportReference(fqName)
        val priority = sameFqNameDescriptors.map { prioritizer.priority(it) }.min() ?: return@mapNotNull null
        Prioritizer.VariantWithPriority(SingleImportVariant(fqName, sameFqNameDescriptors), priority)
    }.sortedBy { it.priority }.map { it.variant }

    return KotlinAddImportAction(project, editor, element, variants)
}

internal fun createSingleImportActionForConstructor(
    project: Project,
    editor: Editor,
    element: KtElement,
    fqNames: Collection<FqName>
): KotlinAddImportAction {
    val file = element.containingKtFile
    val prioritizer = Prioritizer(element.containingKtFile)
    val variants = fqNames.mapNotNull { fqName ->
        val sameFqNameDescriptors = file.resolveImportReference(fqName.parent())
            .filterIsInstance<ClassDescriptor>()
            .flatMap { it.constructors }

        val priority = sameFqNameDescriptors.asSequence().map { prioritizer.priority(it) }.min() ?: return@mapNotNull null
        Prioritizer.VariantWithPriority(SingleImportVariant(fqName, sameFqNameDescriptors), priority)
    }.sortedBy { it.priority }.map { it.variant }
    return KotlinAddImportAction(project, editor, element, variants)
}

internal fun createGroupedImportsAction(
    project: Project,
    editor: Editor,
    element: KtElement,
    autoImportDescription: String,
    fqNames: Collection<FqName>
): KotlinAddImportAction {
    val prioritizer = DescriptorGroupPrioritizer(element.containingKtFile)

    val file = element.containingKtFile
    val variants = fqNames
        .groupBy { it.parentOrNull() ?: FqName.ROOT }
        .map {
            val samePackageFqNames = it.value
            val descriptors = samePackageFqNames.flatMap { fqName -> file.resolveImportReference(fqName) }
            val variant = if (samePackageFqNames.size > 1) {
                GroupedImportVariant(autoImportDescription, descriptors)
            } else {
                SingleImportVariant(samePackageFqNames.first(), descriptors)
            }

            val priority = prioritizer.priority(descriptors)
            DescriptorGroupPrioritizer.VariantWithPriority(variant, priority)
        }
        .sortedBy {
            it.priority
        }
        .map { it.variant }

    return KotlinAddImportAction(project, editor, element, variants)
}

/**
 * Automatically adds import directive to the file for resolving reference.
 * Based on {@link AddImportAction}
 */
class KotlinAddImportAction internal constructor(
    private val project: Project,
    private val editor: Editor,
    private val element: KtElement,
    private val variants: List<AutoImportVariant>
) : QuestionAction {
    fun showHint(): Boolean {
        if (variants.isEmpty()) return false

        val hintText = ShowAutoImportPass.getMessage(variants.size > 1, variants.first().hint)
        HintManager.getInstance().showQuestionHint(editor, hintText, element.textOffset, element.textRange!!.endOffset, this)

        return true
    }

    fun isUnambiguous(): Boolean {
        return variants.size == 1 && variants[0].descriptorsToImport.all { it is ClassDescriptor }
    }

    override fun execute(): Boolean {
        PsiDocumentManager.getInstance(project).commitAllDocuments()
        if (!element.isValid) return false
        if (variants.isEmpty()) return false

        if (variants.size == 1 || ApplicationManager.getApplication().isUnitTestMode) {
            addImport(variants.first())
            return true
        }

        object : ListPopupImpl(getVariantSelectionPopup()) {
            override fun getListElementRenderer(): ListCellRenderer<AutoImportVariant> {
                val baseRenderer = super.getListElementRenderer() as PopupListElementRenderer
                val psiRenderer = DefaultPsiElementCellRenderer()
                return ListCellRenderer { list, value, index, isSelected, cellHasFocus ->
                    JPanel(BorderLayout()).apply {
                        baseRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus)
                        add(baseRenderer.nextStepLabel, BorderLayout.EAST)
                        add(
                            psiRenderer.getListCellRendererComponent(
                                list,
                                value.declarationToImport(project),
                                index,
                                isSelected,
                                cellHasFocus
                            )
                        )
                    }
                }
            }
        }.showInBestPositionFor(editor)

        return true
    }

    private fun getVariantSelectionPopup(): BaseListPopupStep<AutoImportVariant> {
        return object : BaseListPopupStep<AutoImportVariant>(KotlinBundle.message("imports.chooser.title"), variants) {
            override fun isAutoSelectionEnabled() = false

            override fun isSpeedSearchEnabled() = true

            override fun onChosen(selectedValue: AutoImportVariant?, finalChoice: Boolean): PopupStep<String>? {
                if (selectedValue == null || project.isDisposed) return null

                if (finalChoice) {
                    addImport(selectedValue)
                    return null
                }

                val toExclude = AddImportAction.getAllExcludableStrings(selectedValue.excludeFqNameCheck.asString())

                return object : BaseListPopupStep<String>(null, toExclude) {
                    override fun getTextFor(value: String): String {
                        return "Exclude '$value' from auto-import"
                    }

                    override fun onChosen(selectedValue: String, finalChoice: Boolean): PopupStep<Any>? {
                        if (finalChoice && !project.isDisposed) {
                            AddImportAction.excludeFromImport(project, selectedValue)
                        }
                        return null
                    }
                }
            }

            override fun hasSubstep(selectedValue: AutoImportVariant?) = true
            override fun getTextFor(value: AutoImportVariant) = value.hint
            override fun getIconFor(value: AutoImportVariant) = value.icon(project)
        }
    }

    private fun addImport(variant: AutoImportVariant) {
        val psiDocumentManager = PsiDocumentManager.getInstance(project)
        psiDocumentManager.commitAllDocuments()

        project.executeWriteCommand(QuickFixBundle.message("add.import")) {
            if (!element.isValid) return@executeWriteCommand

            val file = element.containingKtFile

            variant.declarationToImport(project)?.let {
                val location = ProximityLocation(element, ModuleUtilCore.findModuleForPsiElement(element))
                StatisticsManager.getInstance().incUseCount(PsiProximityComparator.STATISTICS_KEY, it, location)
            }

            variant.descriptorsToImport.forEach { descriptor ->
                // for class or package we use ShortenReferences because we not necessary insert an import but may want to
                // insert partly qualified name

                val importableFqName = descriptor.importableFqName
                val importAlias = importableFqName?.let { file.findAliasByFqName(it) }
                if (importableFqName?.isOneSegmentFQN() != true &&
                    (importAlias != null || descriptor is ClassDescriptor || descriptor is PackageViewDescriptor)
                ) {
                    if (element is KtSimpleNameExpression) {
                        if (importAlias != null) {
                            importAlias.nameIdentifier?.copy()?.let { element.getIdentifier()?.replace(it) }
                            val resultDescriptor = element.resolveMainReferenceToDescriptors().firstOrNull()
                            if (importableFqName == resultDescriptor?.importableFqName) {
                                return@forEach
                            }
                        }

                        importableFqName?.let {
                            element.mainReference.bindToFqName(
                                it,
                                KtSimpleNameReference.ShorteningMode.FORCED_SHORTENING,
                                targetElement = descriptor.findPsi()
                            )
                        }
                    }
                } else {
                    ImportInsertHelper.getInstance(project).importDescriptor(file, descriptor)
                }
            }
        }
    }
}

private class Prioritizer(private val file: KtFile, private val compareNames: Boolean = true) {
    private val classifier = ImportableFqNameClassifier(file)
    private val proximityComparator = PsiProximityComparator(file)

    inner class Priority(descriptor: DeclarationDescriptor) : Comparable<Priority> {
        private val isDeprecated = KotlinBuiltIns.isDeprecated(descriptor)
        private val fqName = descriptor.importableFqName!!
        private val classification = classifier.classify(fqName, false)
        private val declaration = DescriptorToSourceUtilsIde.getAnyDeclaration(file.project, descriptor)

        override fun compareTo(other: Priority): Int {
            if (isDeprecated != other.isDeprecated) {
                return if (isDeprecated) +1 else -1
            }

            val c1 = classification.compareTo(other.classification)
            if (c1 != 0) return c1

            val c2 = proximityComparator.compare(declaration, other.declaration)
            if (c2 != 0) return c2

            if (compareNames) {
                return fqName.asString().compareTo(other.fqName.asString())
            }

            return 0
        }
    }

    fun priority(descriptor: DeclarationDescriptor) = Priority(descriptor)

    data class VariantWithPriority(val variant: AutoImportVariant, val priority: Priority)
}

private class DescriptorGroupPrioritizer(file: KtFile) {
    private val prioritizer = Prioritizer(file, false)

    inner class Priority(val descriptors: List<DeclarationDescriptor>) : Comparable<Priority> {
        val ownDescriptorsPriority = descriptors.asSequence().map { prioritizer.priority(it) }.max()!!

        override fun compareTo(other: Priority): Int {
            val c1 = ownDescriptorsPriority.compareTo(other.ownDescriptorsPriority)
            if (c1 != 0) return c1

            return other.descriptors.size - descriptors.size
        }
    }

    fun priority(descriptors: List<DeclarationDescriptor>) = Priority(descriptors)

    data class VariantWithPriority(val variant: AutoImportVariant, val priority: Priority)
}

internal interface AutoImportVariant {
    val descriptorsToImport: Collection<DeclarationDescriptor>
    val hint: String
    val excludeFqNameCheck: FqName

    fun icon(project: Project) = KotlinDescriptorIconProvider.getIcon(descriptorsToImport.first(), declarationToImport(project), 0)

    fun declarationToImport(project: Project): PsiElement? =
        DescriptorToSourceUtilsIde.getAnyDeclaration(project, descriptorsToImport.first())
}

private class GroupedImportVariant(
    val autoImportDescription: String,
    val descriptors: Collection<DeclarationDescriptor>
) : AutoImportVariant {
    override val excludeFqNameCheck: FqName = descriptors.first().importableFqName!!.parent()
    override val descriptorsToImport: Collection<DeclarationDescriptor> get() = descriptors
    override val hint: String get() = "$autoImportDescription from $excludeFqNameCheck"
}

private class SingleImportVariant(
    override val excludeFqNameCheck: FqName,
    val descriptors: Collection<DeclarationDescriptor>
) : AutoImportVariant {
    override val descriptorsToImport: Collection<DeclarationDescriptor>
        get() = listOf(
            descriptors.singleOrNull()
                ?: descriptors.minBy { if (it is ClassDescriptor) 0 else 1 }
                ?: error("we create the class with not-empty descriptors always")
        )

    override val hint: String get() = excludeFqNameCheck.asString()
}
