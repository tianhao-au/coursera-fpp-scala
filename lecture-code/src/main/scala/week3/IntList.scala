package week3

trait IntList

class Cons(val head: Int, val tail: IntList) extends IntList

class Nil extends IntList