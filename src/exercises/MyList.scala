package exercises

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](a: B): MyList[B]
  def print: String
  override def toString: String = "[" + print + "]"
  // higher-order functions
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]
  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](a: B): MyList[B] = new MyListImpl(a, Empty)
  def print: String = ""
  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class MyListImpl[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](a: B): MyList[B] = new MyListImpl(a, this)
  def print: String =
    if (tail.isEmpty) "" + h
    else h + " " + t.print
  def map[B](transformer: A => B): MyList[B] =
    new MyListImpl(transformer(h), t.map(transformer))
  def ++[B >: A](list: MyList[B]): MyList[B] = new MyListImpl(h, t ++ list)
  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)
  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new MyListImpl(h, t.filter(predicate))
    else t.filter(predicate)
}

object MyListTest extends App {
  val listOfIntegers: MyList[Int] = MyListImpl(1, MyListImpl(2, Empty))
  val listOfStrings: MyList[String] = MyListImpl("Java", MyListImpl("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
  println(listOfIntegers.head)

  println(listOfIntegers.map(new Function1[Int, Int] {
    override def apply(el: Int): Int = el * 2
  }))

  println(listOfIntegers.filter((el: Int) => el % 2 == 0).toString)


}
