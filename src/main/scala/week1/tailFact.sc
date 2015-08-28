package week1

object tailFact {
  def fact(x: Int) = {

		def ft(x: Int, p: Int): Int =
			if (x == 0) p else ft(x-1, p * x)

  	ft(x, 1)
	}                                         //> fact: (x: Int)Int
	fact(0)                                   //> res0: Int = 1
	fact(1)                                   //> res1: Int = 1
	fact(2)                                   //> res2: Int = 2
	fact(3)                                   //> res3: Int = 6
	fact(4)                                   //> res4: Int = 24
	fact(5)                                   //> res5: Int = 120
}