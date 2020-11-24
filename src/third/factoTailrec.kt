package main.third

fun main(args: Array<String>) {
    val result = factorTailed(7)

    println("result is $result")
}

tailrec fun factorTailed(num: Int, acc: Int = 1): Int = when(num) {
    0 -> acc
    1 -> acc
    else -> factorTailed(num - 1, num * acc)
}
