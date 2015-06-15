package week4

trait Nat {
  def isZero: Boolean

  def predecessor: Nat

  def successor: Nat = new Succ(this)

  def +(that: Nat): Nat

  def -(that: Nat): Nat
}

object Zero extends Nat {
  override def isZero: Boolean = true

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = if (that.isZero) this else throw new Error("negative number")

  override def predecessor: Nat = throw new Error("0.predecessor")
}

class Succ(x: Nat) extends Nat {
  override def isZero: Boolean = false

  override def +(that: Nat): Nat = new Succ(x + that)

  override def -(that: Nat): Nat = if (that.isZero) this else x - that.predecessor

  override def predecessor: Nat = x
}