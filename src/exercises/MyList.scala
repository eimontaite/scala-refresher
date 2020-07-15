package exercises

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](a: B): MyList[B]
  def print: String
  override def toString: String = "[" + print + "]"
  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](a: B): MyList[B] = new MyListImpl(a, Empty)
  def print: String = ""
  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
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
  def map[B](transformer: MyTransformer[A, B]): MyList[B] =
    new MyListImpl(transformer.transform(h), t.map(transformer))
  def ++[B >: A](list: MyList[B]): MyList[B] = new MyListImpl(h, t ++ list)
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)
  def filter(predicate: MyPredicate[A]): MyList[A] =
    if (predicate.test(h)) new MyListImpl(h, t.filter(predicate))
    else t.filter(predicate)
}

trait MyPredicate[-T] {
  def test(el: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(el: A): B
}

object MyListTest extends App {
  val listOfIntegers: MyList[Int] = MyListImpl(1, MyListImpl(2, Empty))
  val listOfStrings: MyList[String] = MyListImpl("Java", MyListImpl("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
  println(listOfIntegers.head)

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(el: Int): Int = el * 2
  }))

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(el: Int): Boolean = el % 2 == 0
  }).toString)


}
