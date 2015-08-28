package week1

/**
 * @author roberto.zagni
 */
object sqrtNewton {
    def sqrt(x2: Double) = {

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
  }

}