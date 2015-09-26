package week4

/**
 * @author roberto.zagni
 */
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head ?! A Nil list is always empty and does not have an head!")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail ?! A Nil list is always empty and does not have an tail!") 
}
