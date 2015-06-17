object testList {
  def removeAt(n: Int, xs: List[Int]): List[Int] = (xs take n) ::: (xs drop n + 1)

  def scaleList(xs: List[Double], factor: Double): List[Double] = xs map (x => x * factor)
  scaleList(List(1, 2, 3, 4, 5), 2.0)

  def posElems(xs: List[Int]): List[Int] = xs filter (x => x > 0)
  posElems(List(-2, -1, 0, 1, 2))

  val nums = List(1, 2, -4, 5, 7, 1)
  val fruits = List("apple", "pineapple", "orange", "banana")

  nums filter (x => x > 0)
  nums filterNot (x => x > 0)
  nums partition (x => x > 0)

  nums takeWhile (x => x > 0)
  nums dropWhile (x => x > 0)
  nums span (x => x > 0)

  val testList = List("a", "a", "a", "b", "c", "c", "a")

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil      => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }
  pack(testList)

  def encode[T](xs: List[T]): List[(T, Int)] = {
    pack(xs) map (ys => (ys.head, ys.length))
  }

  encode(testList)

  val xs = List(1, 2, 3, 4, 5)
  xs.foldLeft(5) {(a, x) =>
    println("a: " + a + ", x: " + x)
    a + x}
  xs.foldRight(5) {(a, x) =>
    println("a: " + a + ", x: " + x)
    a + x}
  def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys) (_ :: _)
}
