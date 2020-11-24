package main.third

private operator fun <T> Sequence<T>.plus(other: () -> Sequence<T>) = object : Sequence<T> {
    val thisIterator: Iterator<T> by lazy { this@plus.iterator() }
    val otherIterator: Iterator<T> by lazy { other().iterator() }

    override fun iterator() = object : Iterator<T> {
        override fun next(): T =
                if (thisIterator.hasNext())
                    thisIterator.next()
                else
                    otherIterator.next()
        override fun hasNext(): Boolean = thisIterator.hasNext() || otherIterator.hasNext()
    }
}

fun main(args: Array<String>) {
    println(takeSequence(5, repeat(3)))
}

fun repeat(num: Int): Sequence<Int> = sequenceOf(num) + { repeat(num) }

fun takeSequence(count: Int, sequence: Sequence<Int>): List<Int> = when {
    count <= 0 -> listOf()
    sequence.none() -> listOf()
    else -> listOf(sequence.first()).plus(takeSequence(count - 1, sequence.drop(1)))
}
