package main.seventh

import main.seventh.domain.Cons
import main.seventh.domain.Nil
import main.seventh.domain.addHead
import main.seventh.domain.first


fun main(args: Array<String>) {
    val lst = Cons(5, Cons(4, Cons(2, Nil))).fmap { "$it" }

    lst.addHead(1)

    println(lst)

    println("first is ${lst.first()}")
}
