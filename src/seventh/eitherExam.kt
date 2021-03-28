package main.seventh

import main.seventh.domain.divideTenByNum

fun main(args: Array<String>) {
    val divideFive = divideTenByNum(5)
    val multiplyTen = divideFive.fmap { it * 10 }
    val multiplyZero = divideFive.fmap { it * 0 }
    val zeroExcept = divideTenByNum(0)

    println(divideFive)
    println(multiplyTen)
    println(multiplyZero)
    println(zeroExcept)
}
