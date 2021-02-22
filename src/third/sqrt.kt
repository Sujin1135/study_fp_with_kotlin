package main.third

import kotlin.math.sqrt

fun main(args: Array<String>) {
    val result = getOne(4.0)

    println("result is $result")
}

tailrec fun getOne(num: Double): Double = when {
    num < 1.0 -> num
    else -> {
        val squaredNum = sqrt(num)
        val dividedNum = divide(squaredNum)

        getOne(dividedNum)
    }
}

private fun divide(num: Double): Double = num / 2
