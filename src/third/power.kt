package main.third

fun main(args: Array<String>) {
    println(power(10.0))
}

fun power(num: Double, squareTime: Int = num.toInt()): Double = when (squareTime) {
    1 -> num
    else -> {
        println(num)
        num * power(num, squareTime - 1)
    }
}
