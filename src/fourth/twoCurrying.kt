package main.fourth

fun main(args: Array<String>) {
    fun <P1, P2, R> ((P1, P2) -> R).curried(): (P1) -> (P2) -> R = {
        p1: P1 -> { p2: P2 -> this(p1, p2) }
    }

    fun <P1, P2, R> ((P1) -> (P2) -> R).uncurried(): (P1, P2) -> R = {
        p1: P1, p2: P2 -> this(p1)(p2)
    }

    val findMin = { num1:Int, num2: Int -> if (num1 < num2) num1 else num2 }

    val curriedFindMin = findMin.curried()

    println(curriedFindMin(5)(3))

    val uncurriedFindMin = curriedFindMin.uncurried()

    println(uncurriedFindMin(3, 5))
}
