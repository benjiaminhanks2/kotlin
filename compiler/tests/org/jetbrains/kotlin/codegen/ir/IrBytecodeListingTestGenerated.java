/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.codegen.ir;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/codegen/bytecodeListing")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class IrBytecodeListingTestGenerated extends AbstractIrBytecodeListingTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
    }

    public void testAllFilesPresentInBytecodeListing() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
    }

    @TestMetadata("callableNameIntrinsic.kt")
    public void testCallableNameIntrinsic() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/callableNameIntrinsic.kt");
    }

    @TestMetadata("companionObjectVisibility_after.kt")
    public void testCompanionObjectVisibility_after() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/companionObjectVisibility_after.kt");
    }

    @TestMetadata("companionObjectVisibility_before.kt")
    public void testCompanionObjectVisibility_before() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/companionObjectVisibility_before.kt");
    }

    @TestMetadata("companionObjectVisibility_lv13.kt")
    public void testCompanionObjectVisibility_lv13() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/companionObjectVisibility_lv13.kt");
    }

    @TestMetadata("defaultImpls.kt")
    public void testDefaultImpls() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/defaultImpls.kt");
    }

    @TestMetadata("emptyMultifileFacade.kt")
    public void testEmptyMultifileFacade() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/emptyMultifileFacade.kt");
    }

    @TestMetadata("extension.kt")
    public void testExtension() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/extension.kt");
    }

    @TestMetadata("immutableCollection.kt")
    public void testImmutableCollection() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/immutableCollection.kt");
    }

    @TestMetadata("jvmOverloadsAndParametersAnnotations.kt")
    public void testJvmOverloadsAndParametersAnnotations() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/jvmOverloadsAndParametersAnnotations.kt");
    }

    @TestMetadata("jvmStaticWithDefaultParameters.kt")
    public void testJvmStaticWithDefaultParameters() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/jvmStaticWithDefaultParameters.kt");
    }

    @TestMetadata("lateInitNotNull.kt")
    public void testLateInitNotNull() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/lateInitNotNull.kt");
    }

    @TestMetadata("noCollectionStubMethodsInInterface.kt")
    public void testNoCollectionStubMethodsInInterface() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/noCollectionStubMethodsInInterface.kt");
    }

    @TestMetadata("noDelegationsToPrivateInterfaceMembers.kt")
    public void testNoDelegationsToPrivateInterfaceMembers() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/noDelegationsToPrivateInterfaceMembers.kt");
    }

    @TestMetadata("noReceiverInCallableReferenceClasses.kt")
    public void testNoReceiverInCallableReferenceClasses() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/noReceiverInCallableReferenceClasses.kt");
    }

    @TestMetadata("noRemoveAtInReadOnly.kt")
    public void testNoRemoveAtInReadOnly() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/noRemoveAtInReadOnly.kt");
    }

    @TestMetadata("noToArrayInJava.kt")
    public void testNoToArrayInJava() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/noToArrayInJava.kt");
    }

    @TestMetadata("platformTypes.kt")
    public void testPlatformTypes() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/platformTypes.kt");
    }

    @TestMetadata("privateDefaultImpls.kt")
    public void testPrivateDefaultImpls() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/privateDefaultImpls.kt");
    }

    @TestMetadata("privateDefaultSetter.kt")
    public void testPrivateDefaultSetter() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/privateDefaultSetter.kt");
    }

    @TestMetadata("samAdapterAndInlinedOne.kt")
    public void testSamAdapterAndInlinedOne() throws Exception {
        runTest("compiler/testData/codegen/bytecodeListing/samAdapterAndInlinedOne.kt");
    }

    @TestMetadata("compiler/testData/codegen/bytecodeListing/annotations")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Annotations extends AbstractIrBytecodeListingTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
        }

        public void testAllFilesPresentInAnnotations() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/annotations"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
        }

        @TestMetadata("defaultTargets.kt")
        public void testDefaultTargets() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/annotations/defaultTargets.kt");
        }

        @TestMetadata("deprecatedJvmOverloads.kt")
        public void testDeprecatedJvmOverloads() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/annotations/deprecatedJvmOverloads.kt");
        }

        @TestMetadata("JvmSynthetic.kt")
        public void testJvmSynthetic() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/annotations/JvmSynthetic.kt");
        }

        @TestMetadata("kt27895.kt")
        public void testKt27895() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/annotations/kt27895.kt");
        }

        @TestMetadata("kt9320.kt")
        public void testKt9320() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/annotations/kt9320.kt");
        }

        @TestMetadata("literals.kt")
        public void testLiterals() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/annotations/literals.kt");
        }

        @TestMetadata("localClassWithCapturedParams.kt")
        public void testLocalClassWithCapturedParams() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/annotations/localClassWithCapturedParams.kt");
        }

        @TestMetadata("noAdditionalAnnotationsInAccessors.kt")
        public void testNoAdditionalAnnotationsInAccessors() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/annotations/noAdditionalAnnotationsInAccessors.kt");
        }

        @TestMetadata("noAnnotationsInSyntheticAccessors.kt")
        public void testNoAnnotationsInSyntheticAccessors() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/annotations/noAnnotationsInSyntheticAccessors.kt");
        }

        @TestMetadata("onProperties.kt")
        public void testOnProperties() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/annotations/onProperties.kt");
        }

        @TestMetadata("onReceiver.kt")
        public void testOnReceiver() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/annotations/onReceiver.kt");
        }
    }

    @TestMetadata("compiler/testData/codegen/bytecodeListing/collectionStubs")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class CollectionStubs extends AbstractIrBytecodeListingTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
        }

        public void testAllFilesPresentInCollectionStubs() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/collectionStubs"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
        }

        @TestMetadata("noStubsInJavaSuperClass.kt")
        public void testNoStubsInJavaSuperClass() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/collectionStubs/noStubsInJavaSuperClass.kt");
        }

        @TestMetadata("stubsFromSuperclass.kt")
        public void testStubsFromSuperclass() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/collectionStubs/stubsFromSuperclass.kt");
        }

        @TestMetadata("stubsFromSuperclassNoBridges.kt")
        public void testStubsFromSuperclassNoBridges() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/collectionStubs/stubsFromSuperclassNoBridges.kt");
        }
    }

    @TestMetadata("compiler/testData/codegen/bytecodeListing/coroutines")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Coroutines extends AbstractIrBytecodeListingTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
        }

        private void runTestWithPackageReplacement(String testDataFilePath, String packageName) throws Exception {
            KotlinTestUtils.runTest(filePath -> doTestWithCoroutinesPackageReplacement(filePath, packageName), TargetBackend.JVM_IR, testDataFilePath);
        }

        public void testAllFilesPresentInCoroutines() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/coroutines"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
        }

        @TestMetadata("coroutineContextIntrinsic.kt")
        public void testCoroutineContextIntrinsic_1_3() throws Exception {
            runTestWithPackageReplacement("compiler/testData/codegen/bytecodeListing/coroutines/coroutineContextIntrinsic.kt", "kotlin.coroutines");
        }

        @TestMetadata("coroutineFields.kt")
        public void testCoroutineFields_1_3() throws Exception {
            runTestWithPackageReplacement("compiler/testData/codegen/bytecodeListing/coroutines/coroutineFields.kt", "kotlin.coroutines");
        }

        @TestMetadata("oomInReturnUnit.kt")
        public void testOomInReturnUnit_1_3() throws Exception {
            runTestWithPackageReplacement("compiler/testData/codegen/bytecodeListing/coroutines/oomInReturnUnit.kt", "kotlin.coroutines");
        }

        @TestMetadata("privateAccessor.kt")
        public void testPrivateAccessor_1_3() throws Exception {
            runTestWithPackageReplacement("compiler/testData/codegen/bytecodeListing/coroutines/privateAccessor.kt", "kotlin.coroutines");
        }

        @TestMetadata("privateSuspendFun.kt")
        public void testPrivateSuspendFun() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/coroutines/privateSuspendFun.kt");
        }

        @TestMetadata("suspendReifiedFun.kt")
        public void testSuspendReifiedFun_1_3() throws Exception {
            runTestWithPackageReplacement("compiler/testData/codegen/bytecodeListing/coroutines/suspendReifiedFun.kt", "kotlin.coroutines");
        }

        @TestMetadata("tcoContinuation.kt")
        public void testTcoContinuation_1_3() throws Exception {
            runTestWithPackageReplacement("compiler/testData/codegen/bytecodeListing/coroutines/tcoContinuation.kt", "kotlin.coroutines");
        }

        @TestMetadata("compiler/testData/codegen/bytecodeListing/coroutines/spilling")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Spilling extends AbstractIrBytecodeListingTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
            }

            public void testAllFilesPresentInSpilling() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/coroutines/spilling"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
            }

            @TestMetadata("component1.kt")
            public void testComponent1() throws Exception {
                runTest("compiler/testData/codegen/bytecodeListing/coroutines/spilling/component1.kt");
            }

            @TestMetadata("destructured.kt")
            public void testDestructured() throws Exception {
                runTest("compiler/testData/codegen/bytecodeListing/coroutines/spilling/destructured.kt");
            }

            @TestMetadata("field.kt")
            public void testField() throws Exception {
                runTest("compiler/testData/codegen/bytecodeListing/coroutines/spilling/field.kt");
            }

            @TestMetadata("lambda.kt")
            public void testLambda() throws Exception {
                runTest("compiler/testData/codegen/bytecodeListing/coroutines/spilling/lambda.kt");
            }

            @TestMetadata("select.kt")
            public void testSelect() throws Exception {
                runTest("compiler/testData/codegen/bytecodeListing/coroutines/spilling/select.kt");
            }

            @TestMetadata("unreachable.kt")
            public void testUnreachable() throws Exception {
                runTest("compiler/testData/codegen/bytecodeListing/coroutines/spilling/unreachable.kt");
            }
        }
    }

    @TestMetadata("compiler/testData/codegen/bytecodeListing/inline")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Inline extends AbstractIrBytecodeListingTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
        }

        public void testAllFilesPresentInInline() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/inline"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
        }

        @TestMetadata("inlineOnly.kt")
        public void testInlineOnly() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inline/inlineOnly.kt");
        }

        @TestMetadata("InlineOnlyMultifile.kt")
        public void testInlineOnlyMultifile() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inline/InlineOnlyMultifile.kt");
        }

        @TestMetadata("inlineOnlyProperty.kt")
        public void testInlineOnlyProperty() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inline/inlineOnlyProperty.kt");
        }

        @TestMetadata("InlineOnlyPropertyMultifile.kt")
        public void testInlineOnlyPropertyMultifile() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inline/InlineOnlyPropertyMultifile.kt");
        }

        @TestMetadata("inlineReified.kt")
        public void testInlineReified() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inline/inlineReified.kt");
        }

        @TestMetadata("InlineReifiedMultifile.kt")
        public void testInlineReifiedMultifile() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inline/InlineReifiedMultifile.kt");
        }

        @TestMetadata("inlineReifiedProperty.kt")
        public void testInlineReifiedProperty() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inline/inlineReifiedProperty.kt");
        }

        @TestMetadata("InlineReifiedPropertyMultifile.kt")
        public void testInlineReifiedPropertyMultifile() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inline/InlineReifiedPropertyMultifile.kt");
        }

        @TestMetadata("simpleNamed.kt")
        public void testSimpleNamed() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inline/simpleNamed.kt");
        }
    }

    @TestMetadata("compiler/testData/codegen/bytecodeListing/inlineClasses")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class InlineClasses extends AbstractIrBytecodeListingTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
        }

        public void testAllFilesPresentInInlineClasses() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/inlineClasses"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
        }

        @TestMetadata("annotationsOnHiddenConstructor.kt")
        public void testAnnotationsOnHiddenConstructor() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inlineClasses/annotationsOnHiddenConstructor.kt");
        }

        @TestMetadata("companionObjectInsideInlineClass.kt")
        public void testCompanionObjectInsideInlineClass() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inlineClasses/companionObjectInsideInlineClass.kt");
        }

        @TestMetadata("computablePropertiesInsideInlineClass.kt")
        public void testComputablePropertiesInsideInlineClass() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inlineClasses/computablePropertiesInsideInlineClass.kt");
        }

        @TestMetadata("constructorsWithDefaultParameterValues.kt")
        public void testConstructorsWithDefaultParameterValues() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inlineClasses/constructorsWithDefaultParameterValues.kt");
        }

        @TestMetadata("inlineClassMembersVisibility.kt")
        public void testInlineClassMembersVisibility() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inlineClasses/inlineClassMembersVisibility.kt");
        }

        @TestMetadata("inlineClassTypeParametersInConstructor.kt")
        public void testInlineClassTypeParametersInConstructor() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inlineClasses/inlineClassTypeParametersInConstructor.kt");
        }

        @TestMetadata("inlineClassWithInlineClassUnderlyingType.kt")
        public void testInlineClassWithInlineClassUnderlyingType() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inlineClasses/inlineClassWithInlineClassUnderlyingType.kt");
        }

        @TestMetadata("inlineClassWithManyKindsOfMembers.kt")
        public void testInlineClassWithManyKindsOfMembers() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inlineClasses/inlineClassWithManyKindsOfMembers.kt");
        }

        @TestMetadata("noBridgesForErasedInlineClass.kt")
        public void testNoBridgesForErasedInlineClass() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inlineClasses/noBridgesForErasedInlineClass.kt");
        }

        @TestMetadata("nullabilityInExpansion.kt")
        public void testNullabilityInExpansion() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inlineClasses/nullabilityInExpansion.kt");
        }

        @TestMetadata("primaryValsWithDifferentVisibilities.kt")
        public void testPrimaryValsWithDifferentVisibilities() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inlineClasses/primaryValsWithDifferentVisibilities.kt");
        }

        @TestMetadata("publishedApiAnnotationOnInlineClassConstructor.kt")
        public void testPublishedApiAnnotationOnInlineClassConstructor() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inlineClasses/publishedApiAnnotationOnInlineClassConstructor.kt");
        }

        @TestMetadata("shapeOfInlineClassWithPrimitive.kt")
        public void testShapeOfInlineClassWithPrimitive() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/inlineClasses/shapeOfInlineClassWithPrimitive.kt");
        }
    }

    @TestMetadata("compiler/testData/codegen/bytecodeListing/jvm8")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Jvm8 extends AbstractIrBytecodeListingTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
        }

        public void testAllFilesPresentInJvm8() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/jvm8"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
        }

        @TestMetadata("compiler/testData/codegen/bytecodeListing/jvm8/defaults")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Defaults extends AbstractIrBytecodeListingTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
            }

            public void testAllFilesPresentInDefaults() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/jvm8/defaults"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
            }

            @TestMetadata("compiler/testData/codegen/bytecodeListing/jvm8/defaults/allCompatibility")
            @TestDataPath("$PROJECT_ROOT")
            @RunWith(JUnit3RunnerWithInners.class)
            public static class AllCompatibility extends AbstractIrBytecodeListingTest {
                private void runTest(String testDataFilePath) throws Exception {
                    KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
                }

                public void testAllFilesPresentInAllCompatibility() throws Exception {
                    KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/jvm8/defaults/allCompatibility"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
                }

                @TestMetadata("jvmDefaultWithoutCompatibility.kt")
                public void testJvmDefaultWithoutCompatibility() throws Exception {
                    runTest("compiler/testData/codegen/bytecodeListing/jvm8/defaults/allCompatibility/jvmDefaultWithoutCompatibility.kt");
                }

                @TestMetadata("noDefaultImplsOnEmptySubInterface.kt")
                public void testNoDefaultImplsOnEmptySubInterface() throws Exception {
                    runTest("compiler/testData/codegen/bytecodeListing/jvm8/defaults/allCompatibility/noDefaultImplsOnEmptySubInterface.kt");
                }

                @TestMetadata("compiler/testData/codegen/bytecodeListing/jvm8/defaults/allCompatibility/specialization")
                @TestDataPath("$PROJECT_ROOT")
                @RunWith(JUnit3RunnerWithInners.class)
                public static class Specialization extends AbstractIrBytecodeListingTest {
                    private void runTest(String testDataFilePath) throws Exception {
                        KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
                    }

                    public void testAllFilesPresentInSpecialization() throws Exception {
                        KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/jvm8/defaults/allCompatibility/specialization"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
                    }

                    @TestMetadata("primitiveAndAny.kt")
                    public void testPrimitiveAndAny() throws Exception {
                        runTest("compiler/testData/codegen/bytecodeListing/jvm8/defaults/allCompatibility/specialization/primitiveAndAny.kt");
                    }

                    @TestMetadata("primitiveAndNullable.kt")
                    public void testPrimitiveAndNullable() throws Exception {
                        runTest("compiler/testData/codegen/bytecodeListing/jvm8/defaults/allCompatibility/specialization/primitiveAndNullable.kt");
                    }
                }
            }
        }
    }

    @TestMetadata("compiler/testData/codegen/bytecodeListing/main")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Main extends AbstractIrBytecodeListingTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
        }

        public void testAllFilesPresentInMain() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/main"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
        }

        @TestMetadata("multifileSuspend.kt")
        public void testMultifileSuspend() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/main/multifileSuspend.kt");
        }

        @TestMetadata("parameterlessMain.kt")
        public void testParameterlessMain() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/main/parameterlessMain.kt");
        }

        @TestMetadata("parameterlessMain_before.kt")
        public void testParameterlessMain_before() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/main/parameterlessMain_before.kt");
        }

        @TestMetadata("suspendMain.kt")
        public void testSuspendMain() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/main/suspendMain.kt");
        }

        @TestMetadata("suspendMain_before.kt")
        public void testSuspendMain_before() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/main/suspendMain_before.kt");
        }
    }

    @TestMetadata("compiler/testData/codegen/bytecodeListing/multiplatform")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Multiplatform extends AbstractIrBytecodeListingTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
        }

        public void testAllFilesPresentInMultiplatform() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/multiplatform"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
        }

        @TestMetadata("optionalExpectation.kt")
        public void testOptionalExpectation() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/multiplatform/optionalExpectation.kt");
        }
    }

    @TestMetadata("compiler/testData/codegen/bytecodeListing/specialBridges")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class SpecialBridges extends AbstractIrBytecodeListingTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
        }

        public void testAllFilesPresentInSpecialBridges() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/specialBridges"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
        }

        @TestMetadata("contains.kt")
        public void testContains() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/specialBridges/contains.kt");
        }

        @TestMetadata("noDefaultImplsOnEmptySubInterface.kt")
        public void testNoDefaultImplsOnEmptySubInterface() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/specialBridges/noDefaultImplsOnEmptySubInterface.kt");
        }

        @TestMetadata("noSpecialBridgeIfPresentInSuperClass.kt")
        public void testNoSpecialBridgeIfPresentInSuperClass() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/specialBridges/noSpecialBridgeIfPresentInSuperClass.kt");
        }

        @TestMetadata("redundantStubForSize.kt")
        public void testRedundantStubForSize() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/specialBridges/redundantStubForSize.kt");
        }

        @TestMetadata("removeAtTwoSpecialBridges.kt")
        public void testRemoveAtTwoSpecialBridges() throws Exception {
            runTest("compiler/testData/codegen/bytecodeListing/specialBridges/removeAtTwoSpecialBridges.kt");
        }

        @TestMetadata("compiler/testData/codegen/bytecodeListing/specialBridges/signatures")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class Signatures extends AbstractIrBytecodeListingTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
            }

            public void testAllFilesPresentInSignatures() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/bytecodeListing/specialBridges/signatures"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
            }

            @TestMetadata("genericClass.kt")
            public void testGenericClass() throws Exception {
                runTest("compiler/testData/codegen/bytecodeListing/specialBridges/signatures/genericClass.kt");
            }

            @TestMetadata("nonGenericClass.kt")
            public void testNonGenericClass() throws Exception {
                runTest("compiler/testData/codegen/bytecodeListing/specialBridges/signatures/nonGenericClass.kt");
            }

            @TestMetadata("partiallySpecializedClass.kt")
            public void testPartiallySpecializedClass() throws Exception {
                runTest("compiler/testData/codegen/bytecodeListing/specialBridges/signatures/partiallySpecializedClass.kt");
            }
        }
    }
}
