package main

interface Box<T>
open class Language
open class JVM : Language()
open class Kotlin : JVM()

// Note: lazyValue는 처음 실행 단계에서 값을 정의한다
val lazyValue: String by lazy {
    println("time-consuming task")
    "hello"
}

fun main(args: Array<String>) {
    val fiboResult: Int = fiboRecursion(100)

    println(fiboResult)
}

private fun fiboRecursion(n: Int): Int = when (n) {
    0 -> 0
    1 -> 1
    else -> fiboRecursion(n - 1) + fiboRecursion(n - 2)
}
