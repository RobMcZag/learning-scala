package week1

object mapReduce {

	def product(f: Int => Int)(a: Int, b: Int): Int =
		if (a > b) 1
		else f(a) * product(f)(a+1, b)    //> product: (f: Int => Int)(a: Int, b: Int)Int
		
	product(x => x * x)(1,4)                  //> res0: Int = 576
	// 1*1 * 2*2 + 3*3 + 4*4
	val r = 1 * 4 * 9 * 16                    //> r  : Int = 576

	def fact(n: Int) : Int =
		product(x => x)(1, n)             //> fact: (n: Int)Int

	fact(4)                                   //> res1: Int = 24
	val f4 = 1 * 2 * 3 * 4                    //> f4  : Int = 24


	def mapReduce(reduce: (Int, Int) => Int, map: Int => Int, zero: Int)(a: Int, b: Int): Int =
		if (a > b) zero
		else reduce(map(a), mapReduce(reduce, map, zero)(a+1, b))
                                                  //> mapReduce: (reduce: (Int, Int) => Int, map: Int => Int, zero: Int)(a: Int, b
                                                  //| : Int)Int
		
	mapReduce ( (f,g) => f * g, x => x*x, 1)(1, 4)
                                                  //> res2: Int = 576
	val gp = 1 * 4 * 9 * 16                   //> gp  : Int = 576

	mapReduce ( (f,g) => f * g, x => x+x, 1)(1, 4)
                                                  //> res3: Int = 384
	val gs = 2 * 4 * 6 * 8                    //> gs  : Int = 384
		
}