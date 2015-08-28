package week1

object gcd {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
	def gcd(a: Int, b: Int): Int = {
		if (b == 0) a else gcd(b, a % b)
	}                                         //> gcd: (a: Int, b: Int)Int

	gcd(12, 16)                               //> res0: Int = 4
  
}