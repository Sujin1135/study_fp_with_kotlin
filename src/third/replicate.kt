package main.third

fun main (args: Array<String>) {
    println(replicate(5, 3))
}

fun replicate (repeatCount: Int, num: Int): List<Int> = when (repeatCount) {
    1 -> listOf(num)
    else -> listOf<Int>(num).plus(replicate(repeatCount - 1, num))
}
