package main.seventh.domain

interface Functor<out A> {
    fun <B> fmap(f: (A) -> B): Functor<B>
}