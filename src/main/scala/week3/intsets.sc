package week3


object intsets {
  
  val e = new EmptyZet()                          //> e  : week3.EmptyZet = .
  
  val t1 = new NonEmptyZet( 7, new EmptyZet, new EmptyZet )
                                                  //> t1  : week3.NonEmptyZet = [.7.]
  
  t1.incl(5).incl(11).incl(3).incl(6)             //> res0: week3.IntSet = [[[.3.]5[.6.]]7[.11.]]
  
}

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
}

class EmptyZet extends IntSet {
	def incl(x: Int): IntSet = new NonEmptyZet(x, new EmptyZet, new EmptyZet)
	def contains(x: Int): Boolean = false
	override def toString = "."
}


class NonEmptyZet(value: Int, inf: IntSet, sup: IntSet) extends IntSet {

	def incl(x: Int): IntSet =
		if (x > value) new NonEmptyZet( value, inf, sup.incl(x))
		else if (x < value) new NonEmptyZet(value, inf.incl(x), sup)
		else this

	def contains(x: Int): Boolean =
		if (x < value ) inf.contains(x)
		else if (x > value ) sup.contains(x)
		else true
		
	override def toString =
		"[" + inf + value + sup + "]"

}