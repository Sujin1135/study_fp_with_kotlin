package main.fourth

fun main(args: Array<String>) {
    fun findMaxNumber(num1: Int) = { num2: Int -> if (num1 > num2) num1 else num2 }

    println(findMaxNumber(3)(2))
}
