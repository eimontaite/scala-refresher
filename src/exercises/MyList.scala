package exercises

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](a: B): MyList[B]
  def print: String
  override def toString: String = "[" + print + "]"
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](a: B): MyList[B] = new MyListImpl(a, Empty)
  def print: String = ""
}

class MyListImpl[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](a: B): MyList[B] = new MyListImpl(a, this)
  def print: String =
    if (tail.isEmpty) "" + h
    else h + " " + t.print
}

object MyListTest extends App {
  val listOfIntegers: MyList[Int] = new MyListImpl(1, new MyListImpl(2, Empty))
  val listOfStrings: MyList[String] = new MyListImpl("Java", new MyListImpl("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
  println(listOfIntegers.head)


}
