package main.fourth

import main.third.head
import main.third.tail

fun main(args: Array<String>) {
    tailrec fun takeWhile(
            condition: (Int, Int) -> Boolean,
            numbers: List<Int>,
            limit: Int,
            acc: List<Int> = listOf()
    ): List<Int> = when {
        numbers.isEmpty() -> acc
        else -> {
            val n = numbers.head()
            val nextList = if (condition(n, limit)) acc.plus(n) else acc
            takeWhile(condition, numbers.tail(), limit, nextList)
        }
    }

    val filteredList = takeWhile({ a, b -> a < b }, listOf(1, 3, 5, 7, 9), 7)

    println(filteredList)
}
