package main.third

fun main(args: Array<String>) {
    val firstList = listOf(1, 2, 3, 4, 5)
    val secondList = listOf(6, 7, 8, 9, 10)

    println(zip(firstList, secondList))
}

fun zip(list1: List<Int>, list2: List<Int>): List<Pair<Int, Int>> = when {
    list1.isEmpty() || list2.isEmpty() -> listOf()
    else -> listOf(Pair(list1.first(), list2.first())).plus(zip(list1.drop(1), list2.drop(1)))
}
