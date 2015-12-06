package week4


object GreeterSheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
	val greeter = new week4.SwedishGreeter()  //> greeter  : week4#35.SwedishGreeter#27580 = week4.SwedishGreeter@3997ebf6
	greeter.SayHi()                           //> Hej världen!

	val greeter2 = new week4.GenGreeter("Ciao")
                                                  //> greeter2  : week4#35.GenGreeter#35025 = week4.GenGreeter@4ab24098
	greeter2.SayHi()                          //> Ciao
	
	val greeter3 = new week4.GenGreeter("Alè ohoh!")
                                                  //> greeter3  : week4#35.GenGreeter#35025 = week4.GenGreeter@7caee177
 
	greeter3.SayHi()                          //> Alè ohoh!
	
	"aString".equalsIgnoreCase("blaBla")      //> res0: Boolean#2523 = false
	
	"aString" equalsIgnoreCase "blaBla"       //> res1: Boolean#2523 = false
}