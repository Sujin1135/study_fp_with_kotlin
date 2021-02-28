package main.fourth

fun main(args: Array<String>) {
    val max = { a: Int -> { b: Int -> if (a > b) a else b } }
    val first = max(5)
    val result = first(2)

    println(result)
}
