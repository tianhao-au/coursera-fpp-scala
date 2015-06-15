package week4

trait ScalaList[+T] {
  def isEmpty: Boolean

  def head: T

  def tail: ScalaList[T]

  def prepend [U >: T] (elem: U): ScalaList[U] = new Cons (elem, this)
}

class Cons[T](val head: T, val tail: ScalaList[T]) extends ScalaList[T] {
  def isEmpty: Boolean = false
}

object Nil extends ScalaList[Nothing] {
  def isEmpty: Boolean = true

  def head: Nothing = throw new NoSuchElementException("Nil.head")

  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object ScalaList {
  def apply[T]() = Nil
  def apply[T](x: T) = new Cons(x, Nil)
  def apply[T](x1: T, x2: T): ScalaList[T] = new Cons(x1, new Cons(x2, Nil))
}

// Nil is list of Nothing, Nothing is subtype of string, list is covariant, so list of Nothing is subtype of list string
object TestMyScalaList {
  val x: ScalaList[String] = Nil

  def f(xs: ScalaList[NonEmpty], x: Empty) = xs prepend x
}