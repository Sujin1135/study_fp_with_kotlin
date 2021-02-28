package main.fourth

fun main(args: Array<String>) {
    val min = { a: Int -> { b: Int -> if (a < b) a else b } }
    val first = min(1)
    val result = first(2)

    println(result)
}
