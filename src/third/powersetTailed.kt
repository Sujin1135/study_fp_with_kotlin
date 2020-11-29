package main.third

fun <T> Collection<T>.powerset(): Set<Set<T>> = powersetTailed(this.toSet())

fun main(args: Array<String>) {
    val result = listOf(1, 2, 3, 4).powerset()

    println("result is $result")
}

tailrec fun <T> powersetTailed(s: Set<T>, acc: Set<Set<T>> = setOf(setOf())): Set<Set<T>> = when {
    s.isEmpty() -> acc
    else -> powersetTailed(s.tail(), acc + acc.map { it + s.head() })
}
