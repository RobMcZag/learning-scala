package week1

object sqrtXX {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def sqrtX(x2: Double) = {

	  def sqrtIter(guess: Double, count: Int ): (Double, Int) = {
	  	if (isGoodGuess(guess)) (guess, count ) else
	  		sqrtIter( improve(guess) , count + 1)
	  }
	  
	  def isGoodGuess(guess: Double) = {
	  		Math.abs( (guess * guess - x2) / x2 ) < 1E-6
	  }

		def improve(guess: Double) =
			(guess + x2 / guess) / 2
  
  	sqrtIter(1, 0)
  }                                               //> sqrtX: (x2: Double)(Double, Int)
  	
	week1.sqrtNewton.sqrt(4)                  //> res0: (Double, Int) = (2.0000000929222947,4)
	
	sqrtX(9)                                  //> res1: (Double, Int) = (3.000000001396984,5)
	
	//sqrt(4E-20)
	//sqrt(4E40)
	//sqrt(4E60)
	
	

}