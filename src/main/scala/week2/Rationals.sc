package week2

object Rationals {

	val r = new Rational(1, 2)                //> r  : week2#31.Rational#143102 = 1/2
	r.num                                     //> res0: Int#1097 = 1
	r.denum                                   //> res1: Int#1097 = 2

	//r.gcd(1, -2)
	r.neg                                     //> res2: week2#31.Rational#143102 = -1/2
	
	
	val s = new Rational(5, 3)                //> s  : week2#31.Rational#143102 = 5/3
	
	r + s                                     //> res3: week2#31.Rational#143102 = 13/6
	r - s                                     //> res4: week2#31.Rational#143102 = -7/6
	
	r < s                                     //> res5: Boolean#2519 = true
	s < r                                     //> res6: Boolean#2519 = false
	s.max(r)                                  //> res7: week2#31.Rational#143102 = 5/3
	
	r == r                                    //> res8: Boolean#2519 = true
	r == s                                    //> res9: Boolean#2519 = false
	r ug new Rational(2, 4)                   //> res10: Boolean#2519 = true
	r ug s                                    //> res11: Boolean#2519 = false
	r ug r                                    //> res12: Boolean#2519 = true
	
	val t = new Rational(2, 1)                //> t  : week2#31.Rational#143102 = 2
	val two = new Rational(2)                 //> two  : week2#31.Rational#143102 = 2
}


class Rational(nump: Int, denump: Int) {
	require( denump != 0, "Denum must be not zero!" )
	private val d = gcd(nump, denump)
	private val s = {if (nump * denump < 0) -1 else 1}
	val num = s * math.abs(nump / d)
	val denum = math.abs(denump / d)
	
	private def gcd(a: Int, b: Int): Int = {
		if (b == 0) a else gcd(b, a % b)
	}

	def this(nump: Int) = this(nump, 1)
	
	def +(that: Rational): Rational =
		new Rational(
			num * that.denum + that.num * denum,
			denum * that.denum
		)
		
	def neg =	new Rational(- num, denum)
		
	def -(that: Rational): Rational = this + that.neg

	def <(that: Rational): Boolean =
		(num * that.denum) < (that.num * denum)
		
	def ==(that: Rational): Boolean =
		(num * that.denum) == (that.num * denum)
		
	def max(that: Rational):Rational =
		if (this < that) that else this

	override def toString =
		if (denum == 1) num.toString()
		else num + "/" + denum
		
	def op(oper: (Int,Int) => Boolean)(that: Rational) =
		oper ((this.num * that.denum) , (that.num * this.denum))
		
	def ug(that: Rational) = op((x:Int, y:Int) => x == y )(that)
		
}