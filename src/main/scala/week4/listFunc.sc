package week4

object listFunc {
	
	def nth[T](n: Int, list: List[T]): T = {
			if (n < 0 ) throw new IndexOutOfBoundsException("n < 0 !!!")	 // NOT NEEDED, just faster :)
			if (list.isEmpty) throw new IndexOutOfBoundsException("Not so many elements in this list !!!")
			if (n == 0) list.head
      else nth(n-1, list.tail)
  }                                               //> nth: [T](n: Int, list: week4.List[T])T


	val el = new Nil;                         //> el  : week4.Nil[Nothing] = week4.Nil@5514cd80
	val l0 = new Cons(0, new Nil)             //> l0  : week4.Cons[Int] = week4.Cons@61917b9e
	val l1 = new Cons(11, l0)                 //> l1  : week4.Cons[Int] = week4.Cons@164af41d
	val l2 = new Cons(22, l1)                 //> l2  : week4.Cons[Int] = week4.Cons@12e0a75a
	
	// nth(1, el)
	
	nth(0, l0)                                //> res0: Int = 0
	//nth(1, l0)
	
	nth(0, l1)                                //> res1: Int = 11
	nth(1, l1)                                //> res2: Int = 0
	//nth(2, l1)
	
	nth(0, l2)                                //> res3: Int = 22
	nth(1, l2)                                //> res4: Int = 11
	nth(2, l2)                                //> res5: Int = 0
	
	val ll0 = List()                          //> ll0  : week4.List[Nothing] = week4.Nil@3bba229e
	val ll1 = List(12)                        //> ll1  : week4.List[Int] = week4.Cons@3936d1b4
	List(11)                                  //> res6: week4.List[Int] = week4.Cons@3e019dc4
	val ll2 = List(11, 22)                    //> ll2  : week4.List[Int] = week4.Cons@5c1ccea9
	ll2                                       //> res7: week4.List[Int] = week4.Cons@5c1ccea9
	List(11, 22, 33, 44)                      //> res8: week4.List[Int] = week4.Cons@6743e87d
	
	
}