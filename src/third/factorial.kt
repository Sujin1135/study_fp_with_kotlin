package main.third

fun main (args: Array<String>) {
    println(factorial(5))
}

fun factorial (num: Int): Int = when (num) {
    1 -> 1
    else -> num * factorial(num - 1)
}
