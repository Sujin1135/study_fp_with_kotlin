package main.third

import main.utils.Bounce
import main.utils.Done
import main.utils.More
import kotlin.math.sqrt

fun divideHalf(n: Double): Bounce<Double> = when {
    n < 1.0 -> Done(n)
    else -> More { calcSqrt(n / 2) }
}

fun calcSqrt(n: Double): Bounce<Double> {
    return More { divideHalf(sqrt(n)) }
}

fun main(args: Array<String>) {
    println(trampoline(divideHalf(5.0)))
}
