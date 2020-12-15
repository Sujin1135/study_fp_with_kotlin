package main.fourth

fun main(args: Array<String>) {
    fun <P1, P2, P3, R> ((P1, P2, P3) -> R).partial1(p1: P1): (P2, P3) -> R {
        return { p2, p3 -> this(p1, p2, p3) }
    }

    fun <P1, P2, R> ((P1, P2) -> R).partial2(p1: P1): (P2) -> R {
        return { p2 -> this(p1, p2) }
    }

    fun <P1, R> ((P1) -> R).partial3(p1: P1): R {
        return this(p1)
    }

    val func = { a: String, b: String, c: String -> "$a $b $c" }

    val result = func.partial1("Hi").partial2("you").partial3("guys")

    println(result)
}
