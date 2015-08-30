package week2

object Rationals {

	val r = new Rational(1, 2)                //> r  : week2#31.Rational#143102 = 1/2
	r.num                                     //> res0: Int#1097 = 1
	r.denum                                   //> res1: Int#1097 = 2

	//r.gcd(1, -2)
	r.neg                                     //> res2: week2#31.Rational#143102 = -1/2
	
	
	val s = new Rational(5, 3)                //> s  : week2#31.Rational#143102 = 5/3
	
	val t = r.add(s)                          //> t  : week2#31.Rational#143102 = 13/6
	val t2 = r.sub(s)                         //> t2  : week2#31.Rational#143102 = -7/6
}


class Rational(nump: Int, denump: Int) {
	val d = gcd(nump, denump)
	val s = {if (nump * denump < 0) -1 else 1}
	def num = s * math.abs(nump / d)
	def denum = math.abs(denump / d)
	
	private def gcd(a: Int, b: Int): Int = {
		if (b == 0) a else gcd(b, a % b)
	}

	def add(that: Rational): Rational =
		new Rational(
			num * that.denum + that.num * denum,
			denum * that.denum
		)
		
	def sub(that: Rational): Rational = add(that.neg)
		
	def neg =	new Rational(- num, denum)

	override def toString =
		if (denum == 1) num.toString()
		else num + "/" + denum
}