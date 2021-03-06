package main.fourth

fun main(args: Array<String>) {
    val func = { a: String, b: String, c: Int -> a + b + c }

    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial1(p1: P1): (P2, P3) -> R {
        return { p2, p3 -> this(p1, p2, p3) }
    }

    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial2(p2: P2): (P1, P3) -> R {
        return { p1, p3 -> this(p1, p2, p3) }
    }

    // examples 4-2 as below
    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial1(p1: P1, p2: P2): (P3) -> R {
        return { p3 -> this(p1, p2, p3) }
    }

    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial2(p1: P1, p3: P3): (P2) -> R {
        return { p2 -> this(p1, p2, p3) }
    }

    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial3(p2: P2, p3: P3): (P1) -> R {
        return { p1 -> this(p1, p2, p3) }
    }
}
