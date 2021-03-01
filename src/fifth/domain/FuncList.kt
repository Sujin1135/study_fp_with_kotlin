package fifth.domain

sealed class FuncList<out T> {
    object Nil : FuncList<Nothing>()
    data class Cons<out T>(val head: T, val tail: FuncList<T>) : FuncList<T>()
}

fun <T> FuncList<T>.addHead(head: T): FuncList<T> = FuncList.Cons(head, this)

tailrec fun <T> FuncList<T>.appendTail(value: T, acc: FuncList<T> = FuncList.Nil): FuncList<T> = when(this) {
    FuncList.Nil -> FuncList.Cons(value, acc).reverse()
    is FuncList.Cons -> tail.appendTail(value, acc.addHead(head))
}

tailrec fun <T> FuncList<T>.reverse(acc: FuncList<T> = FuncList.Nil): FuncList<T> = when(this) {
    FuncList.Nil -> acc
    is FuncList.Cons -> tail.reverse(acc.addHead(head))
}

fun <T> FuncList<T>.getTail(): FuncList<T> = when(this) {
    FuncList.Nil -> throw NoSuchElementException()
    is FuncList.Cons -> tail
}

fun <T> FuncList<T>.getHead(): T = when(this) {
    FuncList.Nil -> throw NoSuchElementException()
    is FuncList.Cons -> head
}

tailrec fun <T> FuncList<T>.filter(p: (T) -> Boolean, acc: FuncList<T> = FuncList.Nil): FuncList<T> = when(this) {
    FuncList.Nil -> acc.reverse()
    is FuncList.Cons -> {
        val addedAcc = if (p(head)) acc.addHead(head) else acc
        tail.filter(p, addedAcc)
    }
}

tailrec fun <T> FuncList<T>.drop(n: Int, curCount: Int = 0, acc: FuncList<T> = FuncList.Nil): FuncList<T> = when(this) {
    FuncList.Nil -> acc.reverse()
    is FuncList.Cons -> {
        val nextCount = curCount + 1
        val addedAcc = if (n <= curCount) acc.addHead(head) else acc
        tail.drop(n, nextCount, addedAcc)
    }
}

tailrec fun <T> FuncList<T>.dropWhile(
    p: (T) -> Boolean,
    isDropped: Boolean = false,
    acc: FuncList<T> = FuncList.Nil
): FuncList<T> = when(this) {
    FuncList.Nil -> acc.reverse()
    is FuncList.Cons -> {
        val isCurDropped = if (!isDropped) p(head) else isDropped
        val addedAcc = if (isCurDropped) acc.addHead(head) else acc
        tail.dropWhile(p, isCurDropped, addedAcc)
    }
}
