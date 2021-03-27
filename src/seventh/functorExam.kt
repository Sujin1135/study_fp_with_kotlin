package main.seventh

import main.seventh.domain.Just
import main.seventh.domain.Nothing

fun main(args: Array<String>) {
    println(Just(10).fmap { it + 5 })

    println(Nothing.fmap { a: Int -> a + 5 })
}
