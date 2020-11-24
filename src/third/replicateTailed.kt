package main.third

fun main(args: Array<String>) {
    val result = replicateTailed(3, 5)

    println("result is $result")
}

tailrec fun replicateTailed(count: Int, num: Int, acc: List<Int> = listOf()): List<Int> = when(count) {
    0 -> acc
    else -> replicateTailed(count - 1, num, acc.plus(num))
}
