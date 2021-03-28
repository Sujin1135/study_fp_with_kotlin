package main.seventh.domain

import kotlin.Nothing

sealed class Tree<out A> : Functor<A> {
    abstract override fun toString(): String

    abstract override fun <B> fmap(f: (A) -> B): Tree<B>
}

object EmptyTree : Tree<Nothing>() {
    override fun toString(): String = "E"

    override fun <B> fmap(f: (Nothing) -> B): Tree<B> = EmptyTree
}

data class Node<out A>(val value: A, val left: Tree<A> = EmptyTree, val right: Tree<A> = EmptyTree) : Tree<A>() {
    override fun toString(): String = "(N $value $left $right)"
    override fun <B> fmap(f: (A) -> B): Tree<B> = Node(f(value), left.fmap(f), right.fmap(f))
}

fun <T> treeOf(value: T, left: Tree<T> = EmptyTree, right: Tree<T> = EmptyTree): Tree<T> =
    Node(value, left, right)
