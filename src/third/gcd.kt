package main.third

fun main(args: Array<String>) {
   println(gcd(30, 100))
}

fun gcd(num: Int, m: Int): Int {
   if (num % m === 0) return m
   else return gcd(m, num % m)
}
