package exercises

abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(a: Int): MyList
  def print: String
  override def toString: String = "[" + print + "]"
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(a: Int): MyList = new MyListImpl(a, Empty)
  def print: String = ""
}

class MyListImpl(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(a: Int): MyList = new MyListImpl(a, this)
  def print: String =
    if (tail.isEmpty) "" + h
    else h + " " + t.print
}

object MyListTest extends App {
  val list = new MyListImpl(1, new MyListImpl(2, new MyListImpl(4, Empty)))
  println(list.head)
  println(list.tail)
  println(list.toString)
}
