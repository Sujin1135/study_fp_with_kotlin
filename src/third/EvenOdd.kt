package main.third

import main.utils.Bounce
import main.utils.Done
import main.utils.More

fun main(args: Array<String>) {
    val result = trampoline(even(9999999))

    println("result is $result")
}

tailrec fun <A> trampoline(bounce: Bounce<A>): A = when (bounce) {
    is Done -> bounce.result
    is More -> {
        println("trampoline")
        trampoline(bounce.thunk())
    }
}

fun odd(n: Int): Bounce<Boolean> = when (n) {
    0 -> Done(false)
    else -> {
        println("odd: $n")
        More { even(n - 1) }
    }
}

fun even(n: Int): Bounce<Boolean> = when (n) {
    0 -> Done(false)
    else -> {
        println("even: $n")
        More { odd(n - 1) }
    }
}
