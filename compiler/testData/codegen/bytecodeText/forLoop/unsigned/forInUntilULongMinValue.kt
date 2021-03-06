// WITH_RUNTIME
const val M = ULong.MIN_VALUE

fun f(a: ULong): Int {
    var n = 0
    for (i in a until M) {
        n++
    }
    return n
}

// For "until" progressions in JVM IR, there is a check that the range is not empty: upper bound != MIN_VALUE.
// When the upper bound == const MIN_VALUE, the backend can eliminate the entire loop as dead code.

// 0 iterator
// 0 getStart
// 0 getEnd
// 0 getFirst
// 0 getLast
// 0 getStep
// 0 INVOKESTATIC kotlin/ULong.constructor-impl
// 0 INVOKE\w+ kotlin/ULong.(un)?box-impl

// JVM_TEMPLATES
// 1 IF

// JVM_IR_TEMPLATES
// 0 IF
// 0 LINENUMBER 7
