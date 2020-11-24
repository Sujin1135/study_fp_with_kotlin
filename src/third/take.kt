package main.third

fun List<Int>.head() = first()
fun List<Int>.tail() = drop(1)

fun main(args: Array<String>) {
    println(take(5, listOf(1, 2, 3, 4, 5, 6, 7)))
}

fun take(count: Int, list: List<Int>): List<Int> = when {
    count <= 0 -> listOf()
    list.isEmpty() -> listOf()
    else -> listOf(list.head()) + take(count - 1, list.tail())
}
