package week1

object highOrderSum {
  
  def sum(f: Int => Int, a: Int, b: Int): Int = {
        def loop(a: Int, acc: Int): Int = {
          if (a > b) acc
          else loop(a+1, f(a) + acc)
        }
        loop(a, 0)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  
  sum( x => x,  2, 5)                             //> res0: Int = 14
  // 2 + 3 + 4 + 5 = 14
 
  sum( x => x,  1, 10)                            //> res1: Int = 55
  
}