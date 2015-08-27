package greeter

object LearningWorksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val x = 5                                       //> x  : Int = 5
  def increase(i: Int) = i + 1                    //> increase: (i: Int)Int
  increase(x)                                     //> res0: Int = 6
  println("The value of x is (" + x + ")")        //> The value of x is (5)
}