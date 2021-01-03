package main.fourth

fun main(args: Array<String>) {
    val min = { n1: Int, n2: Int -> if (n1 < n2) n1 else n2 }

    fun <P1, P2, R> ((P1, P2) -> R).curried(): (P1) -> (P2) -> R = {
        p1: P1 -> { p2: P2 -> this(p1, p2) }
    }

    fun <P1, P2, R> ((P1) -> (P2) -> R).uncurried(): (P1, P2) -> R = {
        p1: P1, p2: P2 -> this(p1)(p2)
    }

    val curriedMin = min.curried()

    println(curriedMin(1)(2))

    val uncurriedMin = curriedMin.uncurried()

    println(uncurriedMin(1, 2))
}
