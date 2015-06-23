package week6

class Poly(val terms0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)
  val terms = terms0 withDefaultValue 0.0
  def +(other: Poly) = new Poly(terms ++ (other.terms map adjust))
  def adjust(term: (Int, Double)): (Int, Double) = {
    val (exp, coeff) = term
    exp -> (coeff + terms(exp))
//    terms get exp match {
//      case Some(coeff1) => exp -> (coeff + coeff1)
//      case None => exp -> coeff
//    }
  }

  def add(other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
  def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
    val (exp, coeff) = term
    terms + (exp -> (coeff + terms(exp)))
  }

  override def toString =
    (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
}

object Polynomials {

//  val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
//  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0)
  p1 + p2
}
