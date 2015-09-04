package week3


object intsets {
  
  val e = EmptyZet                                //> e  : week3.EmptyZet.type = .
  
  val t1 = new NonEmptyZet( 7, EmptyZet, EmptyZet )
                                                  //> t1  : week3.NonEmptyZet = [.7.]
  t1.union(EmptyZet)                              //> res0: week3.IntSet = [.7.]
  
  val t3 = t1.incl(6).incl(11).incl(3).incl(5)    //> t3  : week3.IntSet = [[[.3[.5.]]6.]7[.11.]]
  EmptyZet.union(t1)                              //> res1: week3.IntSet = [.7.]
  t1.union(EmptyZet)                              //> res2: week3.IntSet = [.7.]
	t3.union(EmptyZet)                        //> res3: week3.IntSet = [[.3.]5[.6[[.7.]11.]]]
  
  val t2 = EmptyZet.incl(123).incl(-5)            //> t2  : week3.IntSet = [[.-5.]123.]
  t1.union(t2)                                    //> res4: week3.IntSet = [[.-5[.7.]]123.]
  t3.union(t2).union(EmptyZet.incl(0))            //> res5: week3.IntSet = [[.-5.]0[[.3.]5[.6[[.7.]11[.123.]]]]]
  
  
}

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
	override def toString: String
}

object EmptyZet extends IntSet {
	def incl(x: Int): IntSet = new NonEmptyZet(x, EmptyZet, EmptyZet)
	def contains(x: Int): Boolean = false
	def union(other: IntSet): IntSet = other
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
		
	def union(other: IntSet): IntSet =
		inf.union(sup).union(other).incl(value)
		//if (other == EmptyZet) this else  inf.union(other.incl(value)) .union(this.sup)
		
	override def toString =
		"[" + inf + value + sup + "]"

}