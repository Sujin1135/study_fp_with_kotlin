package main.third

fun main(args: Array<String>) {
   println(factoMemoized(10))
}

fun factoMemoized(n: Int, acc: Long = 1): Long = when(n) {
   1 -> acc
   else -> {
      factoMemoized(n - 1, n * acc)
   }
}
