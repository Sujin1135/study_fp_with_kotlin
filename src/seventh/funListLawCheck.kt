package main.seventh

import main.seventh.domain.Cons
import main.seventh.domain.Nil

infix fun <F, G, R>((F) -> R).compose(g: (G) -> F): (G) -> R {
    return { gInput: G -> this(g(gInput)) }
}

fun main(args: Array<String>) {
    val g = { num: Int -> num * 5 }
    val f = { num: Int -> num + 5 }

    val composed = f compose g

    val lst = Cons(5, Cons(4, Cons(3, Nil)))

    val firstCase = lst.fmap(composed)
    val secondCase = lst.fmap(g).fmap(f)

    println(firstCase)
    println(secondCase)
    println(firstCase == secondCase)
}
