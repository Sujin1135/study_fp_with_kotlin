package main.third

val cache = Array(100) { -1L }

fun main(args: Array<String>) {
   factoMemoized(10)

   println("---------")
   
   factoMemoized(10)
}

fun factoMemoized(n: Int): Long = when {
   n == 1 -> 1L
   cache[n] != -1L -> cache[n]
   else -> {
      println("n: $n")
      cache[n] = n * factoMemoized(n - 1)
      cache[n]
   }
}
