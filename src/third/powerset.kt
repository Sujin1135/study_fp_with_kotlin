package main.third

fun main(args: Array<String>) {
    println(powerset(setOf(1, 2, 3)))
}

fun <T> Set<T>.head() = first()
fun <T> Set<T>.tail() = drop(1).toSet()

fun <T> powerset(s: Set<T>): Set<Set<T>> = when {
    s.isEmpty() -> setOf(setOf())
    else -> {
        val head = s.head()
        val resultSet = powerset(s.tail())
        val result = resultSet + resultSet.map { setOf(head) + it }.toSet()
        println("result is $result")
        result
    }
}
