package week1

object sqrt {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def sqrt(x2: Double) = {

	  def sqrtIter(guess: Double, x2: Double, count: Int ): (Double, Int) = {
	  	if (isGoodGuess(guess, x2)) (guess, count ) else
	  		sqrtIter( improve(guess , x2) , x2, count + 1)
	  }
	  
	  def isGoodGuess(guess: Double, x2: Double) = {
	  		Math.abs( (guess * guess - x2) / x2 ) < 1E-15
	  }

		def improve(guess: Double, x2: Double) =
			(guess + x2 / guess) / 2
  
  	sqrtIter(1, x2, 0)
  }                                               //> sqrt: (x2: Double)(Double, Int)
  	
	sqrt(4)                                   //> res0: (Double, Int) = (2.0,6)
	sqrt(9)                                   //> res1: (Double, Int) = (3.0,6)
	
	sqrt(4E-20)                               //> res2: (Double, Int) = (1.9999999999999998E-10,37)
	sqrt(4E40)                                //> res3: (Double, Int) = (2.0E20,72)
	sqrt(4E60)                                //> res4: (Double, Int) = (2.0E30,105)
	
	

}