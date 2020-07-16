package exercises

object Functions extends App {

  val stringConcat: (String, String) => String = {
    (a: String, b: String) => a.concat(b)
  }

  println(stringConcat("Hello", ", you"))

  def myFunction(a: Int): Int => Int = (b: Int) => {
    a + b
  }

  println(myFunction(2)(5))

  val specialFunction: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }

    val compactSpecialFunction: Function1[Int, Function1[Int, Int]] = (x: Int) => (y: Int) => x + y
    println(compactSpecialFunction(1)(2)) // curried function

  }
}
