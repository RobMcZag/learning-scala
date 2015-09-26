package week4

object listFunc {
	
	def nth[T](n: Int, list: List[T]): T = {
			if (n < 0 ) throw new IndexOutOfBoundsException("n < 0 !!!")	 // NOT NEEDED, just faster :)
			if (list.isEmpty) throw new IndexOutOfBoundsException("Not so many elements in this list !!!")
			if (n == 0) list.head
      else nth(n-1, list.tail)
  }                                               //> nth: [T](n: Int, list: week4.List[T])T


	val el = new Nil;                         //> el  : week4.Nil[Nothing] = week4.Nil@4a15d117
	val l0 = new Cons(0, new Nil)             //> l0  : week4.Cons[Int] = week4.Cons@5a9f0e68
	val l1 = new Cons(11, l0)                 //> l1  : week4.Cons[Int] = week4.Cons@6afc53
	val l2 = new Cons(22, l1)                 //> l2  : week4.Cons[Int] = week4.Cons@6fdbad5b
	
	// nth(1, el)
	
	nth(0, l0)                                //> res0: Int = 0
	//nth(1, l0)
	
	nth(0, l1)                                //> res1: Int = 11
	nth(1, l1)                                //> res2: Int = 0
	//nth(2, l1)
	
	nth(0, l2)                                //> res3: Int = 22
	nth(1, l2)                                //> res4: Int = 11
	nth(2, l2)                                //> res5: Int = 0
}