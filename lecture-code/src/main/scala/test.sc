import week4.{Sum, Product, Number => MyNumber, exprs}
object test {
  def error(msg: String) = throw new Error(msg)
  exprs.show(Product(Sum(MyNumber(2), MyNumber(4)), Sum(MyNumber(6), MyNumber(8))))
  exprs.eval(Product(Sum(MyNumber(2), MyNumber(4)), Sum(MyNumber(6), MyNumber(8))))
  error("ops")
}