package week4

/**
 * @author roberto.zagni
 */
abstract class Greeter {
  var message: String
  
  def SayHi() = println(message)
}

class SwedishGreeter extends Greeter{
  var message = "Hej världen!"
}

class GenGreeter(var message: String) extends Greeter{
}
