package week3

object intestUnion {
	val e = Empty                             //> e  : week3.Empty.type = .
  val s1 = Empty include 3                        //> s1  : week3.NonEmpty = {.3.}
  val s2 = s1 include 5 include 2 include 7       //> s2  : week3.IntSet = {{.2.}3{.5{.7.}}}
  val s3 = s1 include 7 include 2 include 5       //> s3  : week3.IntSet = {{.2.}3{{.5.}7.}}
  val t = Empty include 3 include 1 include 11    //> t  : week3.IntSet = {{.1.}3{.11.}}
  
  t union e                                       //> res0: week3.IntSet = {{.1{.3.}}11.}
  e union t                                       //> res1: week3.IntSet = {{.1.}3{.11.}}
  
  t union s1                                      //> res2: week3.IntSet = {{.1.}3{.11.}}
  t union s2                                      //> res3: week3.IntSet = {{.1.}2{{.3{.5.}}7{.11.}}}
  t union s3                                      //> res4: week3.IntSet = {{.1.}2{{.3{.5.}}7{.11.}}}
}

abstract class IntSet {
	def contains(x: Int): Boolean
	def include(x: Int) : IntSet
	def union(other:IntSet): IntSet
}

object Empty extends IntSet {
	def contains(x: Int) = false
	def include(x: Int) = new NonEmpty(x, Empty, Empty)
	override def toString = "."
	def union(other:IntSet) = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
	def contains(x: Int) = {
		if (x < elem) left.contains(x)
		else if (x > elem) right.contains(x)
		else true
	}
	def include(x: Int) = {
		if (x < elem) new NonEmpty(elem, left.include(x), right)
		else if (x > elem) new NonEmpty(elem, left, right.include(x))
		else this
	}
	override def toString = "{" + left + elem + right + "}"
	def union(other:IntSet) = {
		other.union(left).union(right).include(elem)
	}
}