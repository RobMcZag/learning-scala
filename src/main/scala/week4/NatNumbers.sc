package week4


object NatNumbers {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val zero = Zero                                 //> zero  : week4.Zero.type = 
  val uno = Zero.successor                        //> uno  : week4.Nat = .
  
  zero + uno                                      //> res0: week4.Nat = .
  uno + zero                                      //> res1: week4.Nat = .
  val due = uno + uno                             //> due  : week4.Nat = ..
  val tre = due + uno                             //> tre  : week4.Nat = ...
  val quattro = due + due                         //> quattro  : week4.Nat = ....
  due + tre                                       //> res2: week4.Nat = .....
  quattro - due                                   //> res3: week4.Nat = ..
  quattro - zero                                  //> res4: week4.Nat = ....
  zero - zero                                     //> res5: week4.Nat = 
  
  due - uno                                       //> res6: week4.Nat = .
  zero + quattro                                  //> res7: week4.Nat = ....
  
}