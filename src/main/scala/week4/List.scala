package week4

/**
 * @author roberto.zagni
 */
trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend [U >: T] (elem: U) : List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head ?! A Nil list is always empty and does not have an head!")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail ?! A Nil list is always empty and does not have an tail!") 
}

object List {
	def apply[T]():List[T] = Nil
			
  def apply[T](x1: T): List[T] =
    new Cons(x1, Nil)

  def apply[T](x1: T, x2: T): List[T] =    //    new Cons(x1, new Cons(x2, new Nil))
    new Cons(x1, apply(x2))

  def apply[T](x1: T, x2: T, x3: T): List[T] =
    new Cons(x1, apply(x2, x3))

  def apply[T](x1: T, x2: T, x3: T, x4: T): List[T] =
    new Cons(x1, apply(x2, x3, x4))
}