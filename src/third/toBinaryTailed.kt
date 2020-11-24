package main.third

fun main(args: Array<String>) {
    val result = toBinaryTailed(10)

    println("result is $result")
}

tailrec fun toBinaryTailed(num: Int, acc: String = ""): String = when (num) {
    0 -> acc
    else -> {
        println((num % 2).toString() + acc)
        toBinaryTailed(num / 2, (num % 2).toString() + acc)
    }
}
