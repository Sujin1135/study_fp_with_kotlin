package main.third

fun main(args: Array<String>) {
    println(checkValueOfList(2, listOf(1, 2, 3, 4, 5)))
}

fun checkValueOfList(num: Int, list: List<Int>): Boolean = when {
    list.isEmpty() -> false
    num == list.first() -> true
    else -> checkValueOfList(num, list.drop(1))
}
