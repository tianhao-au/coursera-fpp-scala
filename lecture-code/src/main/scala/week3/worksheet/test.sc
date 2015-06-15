import math.abs

object test {
  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  fixedPoint(x => 1 + x / 2)(1)

  def averageDamp(f: Double => Double)(x: Double): Double = (x + f(x)) / 2

  def sqrt(x: Double): Double =
    fixedPoint(averageDamp(y => x / y))(1)

  sqrt(2)

  def multiply(m: Int)(n: Int): Int = m * n
  def timesTwo = multiply(2) _
  def test(f: Int => Int)(v: Int) = f(v) + v
  test(timesTwo)(3)
  test(multiply(2))(3)
}