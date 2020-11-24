package main.third

fun main(args: Array<String>) {
    val result: Int = power(9)

    println("result is $result")
}

fun power(num: Int): Int = when(num) {
    1 -> num
    else -> powerTailed(num)
}

tailrec fun powerTailed(num: Int, origin: Int = num, acc: Int = num): Int = when(num) {
    1 -> acc
    else -> {
        println(origin * acc)
        powerTailed(num - 1, origin, origin * acc)
    }
}
