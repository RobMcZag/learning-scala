package week2

object exercise2_3 {
	val tolerance = 0.0001                    //> tolerance  : Double = 1.0E-4
	
	def fixedPoint(f: Double => Double)(x: Double) : Double = {
		val fx = f(x)
		if (isCloseEnough(x, fx)) x
		else fixedPoint(f)(averageDamp(f)(x))
	}                                         //> fixedPoint: (f: Double => Double)(x: Double)Double
		
	def isCloseEnough(x: Double, y: Double): Boolean =
		math.abs((x-y)/x) < tolerance     //> isCloseEnough: (x: Double, y: Double)Boolean

	def averageDamp(f: Double => Double) (x: Double): Double =
		(x + f(x)) / 2                    //> averageDamp: (f: Double => Double)(x: Double)Double
				
	fixedPoint(x => 4 + x / 2)(-100)          //> res0: Double = 7.998551851736725
	
	
	def sqrt(x: Double) = fixedPoint(y => x / y)(x)
                                                  //> sqrt: (x: Double)Double
	sqrt(9)                                   //> res1: Double = 3.00009155413138
}