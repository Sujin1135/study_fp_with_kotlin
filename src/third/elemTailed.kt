package main.third

fun main(args: Array<String>) {
    val result = elemTailed(2, listOf(1, 2, 3, 5, 7))

    println("result is $result")
}

tailrec fun elemTailed(num: Int, list: List<Int>, acc: Boolean = false): Boolean = when {
    list.isEmpty() -> false
    acc -> acc
    else -> {
        val head = list.head()
        val isContained = head == num
        if (isContained) true
        else elemTailed(num, list.tail(), isContained)
    }
}
