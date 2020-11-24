package main.third

fun main(args: Array<String>) {
    println(power(2.0))
}

fun power(num: Double, squareTime: Int = num.toInt()): Double = when (squareTime) {
    1 -> num
    else -> num * power(num, squareTime - 1)
}
