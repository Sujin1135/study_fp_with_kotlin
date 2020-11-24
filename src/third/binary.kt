package main.third

fun main (args: Array<String>) {
    println(toBinary(20))
}

fun toBinary (num: Int): String = when (num) {
    1 -> "1"
    in 0 .. 1 -> ""
    else -> toBinary(num / 2) + (num % 2).toString()
}
