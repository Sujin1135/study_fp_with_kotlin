package main.third

import kotlin.math.sqrt

fun main(args: Array<String>) {
    val result = getOne(4.0)

    println("result is $result")
}

fun getOne(num: Double): Double = when {
    num < 1.0 -> num
    else -> {
        val squaredNum = squareRoot(num)
        val devidedNum = devide(squaredNum)

        getOne(devidedNum)
    }
}

private fun devide(num: Double): Double = num / 2

private fun squareRoot(num: Double): Double = sqrt(num)
