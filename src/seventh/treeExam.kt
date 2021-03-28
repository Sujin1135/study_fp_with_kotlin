package main.seventh

import main.seventh.domain.treeOf

fun main(args: Array<String>) {
    val tree = treeOf(5, treeOf(2), treeOf(7))
    val mappedTree = tree.fmap { it + 2 }

    println(tree)
    println(mappedTree)
}
