package week4

import org.scalatest.FlatSpec
import week4.Expressions.{eval, show}

class ExpressionsSpec extends FlatSpec {

  "Expressions" should "eval a number expression" in {
    val result: Int = eval(Number(6))
    assert(result == 6)
  }

  "Expressions" should "eval a sum expression" in {
    val result: Int = eval(Sum(Number(2), Number(8)))
    assertResult(10)(result)
  }

  "Expressions" should "eval a product expression" in {
    val result: Int = eval(Product(Number(2), Number(8)))
    assertResult(16)(result)
  }

  "Expressions" should "show a number expression" in {
    val result: String = show(Number(6))
    assert(result == "6")
  }

  "Expressions" should "show a sum expression" in {
    val result: String = show(Sum(Number(2), Number(8)))
    assert(result == "(2 + 8)")
  }

  "Expressions" should "show a product expression" in {
    val result: String = show(Product(Number(2), Number(8)))
    assert(result == "2 * 8")
  }

  "Expressions" should "show an expression mix with sum and product" in {
    val result: String = show(Product(Sum(Number(2), Number(4)), Sum(Number(6), Number(8))))
    assert(result == "(2 + 4) * (6 + 8)")
  }
}
