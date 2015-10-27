package week4

/**
 * @author roberto.zagni
 */
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  def isZero: Boolean = true
  def predecessor: Nat = throw new Exception("Zero does not have a predecessor.")
  def + (that: Nat): Nat = that
  def - (that: Nat): Nat = 
    if (that.isZero) this
    else throw new Exception("Can not subtract from Zero.")
  override def toString() = ""
}

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false
  def predecessor: Nat = n
  def + (that: Nat): Nat = this.predecessor + that.successor
  def - (that: Nat): Nat = {
    if (that.isZero) this
    else this.predecessor - that.predecessor
  }  
  override def toString() = "."+predecessor.toString()
}
