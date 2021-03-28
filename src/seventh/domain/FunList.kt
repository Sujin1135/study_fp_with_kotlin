package main.seventh.domain

import kotlin.Nothing

sealed class FunList<out A> : Functor<A> {
    override fun <B> fmap(f: (A) -> B): FunList<B> = map(f)
}

object Nil : FunList<Nothing>()

data class Cons<out A>(val head: A, val tail: FunList<A>) : FunList<A>() {
    override fun toString(): String = tailToString()
}

fun <T> FunList<T>.addHead(head: T): FunList<T> = Cons(head, this)

tailrec fun <A, B> FunList<A>.map(f: (A) -> B, acc: FunList<B> = Nil): FunList<B> = when(this) {
    Nil -> acc
    is Cons -> tail.map(f, acc.addHead(f(head)))
}

tailrec fun <T> FunList<T>.tailToString(acc: String = ""): String = when(this) {
    Nil -> acc
    is Cons -> {
        val headStr = if (acc == "") "" else "$acc, "
        tail.tailToString("$headStr${head.toString()}")
    }
}

tailrec fun <T> FunList<T>.size(acc: Int = 0): Int = when(this) {
    Nil -> acc
    is Cons -> tail.size(acc + 1)
}

fun <T> FunList<T>.first(): T = when(this) {
    Nil -> throw NoSuchElementException()
    is Cons -> head
}
