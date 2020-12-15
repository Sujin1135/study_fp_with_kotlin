package main.third

class PartialFunction<P, R> (
    private val condition: (P) -> Boolean,
    private val f: (P) -> R
): (P) -> R {
    override fun invoke(p: P): R = when {
        condition(p) -> f(p)
        else -> throw IllegalArgumentException("$p isn't supported")
    }

    fun isDefinedAt(p: P): Boolean = condition(p)

    fun invokeOrElse(p: P, default: R): R = when {
        condition(p) -> f(p)
        else -> default
    }

    fun orElse(p: P, that: PartialFunction<P, R>): PartialFunction<P, R> = when {
        condition(p) -> this
        else -> that
    }
}

fun <P, R> ((P) -> R).toPartialFunction(definedAt: (P) -> Boolean):
        PartialFunction<P, R> = PartialFunction(definedAt, this)

fun main(args: Array<String>) {
    val condition: (Int) -> Boolean = { it.rem(2) == 0 }
    val body: (Int) -> String = { "$it is even" }

    val isEven = body.toPartialFunction(condition)

    if (isEven.isDefinedAt(101))
        println(isEven(101))
    else
        println("isDefinedAt(x) return false")
}
