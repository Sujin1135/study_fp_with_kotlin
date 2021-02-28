package main.fourth

tailrec fun <P1, P2, R> zipWith(func: (P1, P2) -> R , list1: List<P1>, list2: List<P2>, acc: List<R> = listOf()):
        List<R> = when {
    list1.isEmpty() || list2.isEmpty() -> acc
    else -> {
        val zipList = func(list1.first(), list2.first())
        zipWith(func, list1.drop(1), list2.drop(1), acc + listOf(zipList))
    }
}

fun main(args: Array<String>) {
    val add = { p1: Int, p2: Int -> p1 + p2 }
    val result = zipWith(add, listOf(1, 2, 3, 4, 5), listOf(6, 7, 8, 9, 10))

    result.forEach { o -> println(o) }
}
