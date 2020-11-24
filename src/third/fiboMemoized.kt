package main.third

val memo = Array(100) { -1 }

fun main(args: Array<String>) {
    printIntArray(memo)

    println("-------------")
    fiboMemoized(6)

    println("-------------")

    for (n in memo.filter {it != -1}) {
        println(n)
    }
}

fun printIntArray(intArrays: Array<Int>) {
    for (n in intArrays) println(n)
}

fun fiboMemoized(n: Int): Int = when {
    n == 0 -> 0
    n == 1 -> 1
    memo[n] != -1 -> memo[n]
    else -> {
        println("fiboMemoized($n)")
        memo[n] = fiboMemoized(n - 2) + fiboMemoized(n - 1)
        memo[n]
    }
}
