package main.fourth

import kotlin.math.pow

fun main(args: Array<String>) {
    infix fun <F, G, R> ((F) -> R).compose(g: (G) -> F): (G) -> R {
        return { gInput: G -> this(g(gInput)) }
    }

    val min: (List<Int>) -> Int = { numbers: List<Int> -> numbers.max() ?: 0 }
    val power: (Int) -> Int = { number: Int -> (number.toDouble().pow(2)).toInt()}
    val composed = power compose min

    println(composed(listOf(1, 3, 5, 7)))
}
