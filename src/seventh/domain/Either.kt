package main.seventh.domain

import kotlin.Nothing

sealed class Either<out L, out R> : Functor<R> {
    abstract override fun <R2> fmap(f: (R) -> R2): Either<L, R2>

    fun <T> toString(value: T): String = value.toString()
}

data class Left<out L>(val value: L) : Either<L, Nothing>() {
    override fun <R2> fmap(f: (Nothing) -> R2): Either<L, R2> = this

    override fun toString(): String = toString(value)
}

data class Right<out R>(val value: R) : Either<Nothing, R>() {
    override fun <R2> fmap(f: (R) -> R2): Either<Nothing, R2> = Right(f(value))

    override fun toString(): String = toString(value)
}

// the divide example by Either
fun divideTenByNum(num: Int): Either<String, Int> = try {
    Right(10 / num)
} catch (e: ArithmeticException) {
    Left("Can't divide by zero")
}
