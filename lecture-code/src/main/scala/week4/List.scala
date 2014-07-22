package week4

import java.util.NoSuchElementException

trait List[+T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]

  def prepend [U >: T] (elem: U): List[U] = new Cons (elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {
  def isEmpty = true

  def head: Nothing = throw new NoSuchElementException("Nil.head")

  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object List {
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, Nil))
  def apply[T]() = Nil
}

// Nil is list of Nothing, Nothing is subtype of string, list is covariant, so list of Nothing is subtype of list string
object test {
  val x: List[String] = Nil

  def f(xs: List[NonEmpty], x: Empty) = xs prepend x
}
