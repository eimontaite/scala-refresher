package lectures.part2oop

object Exceptions extends App {
  val x: String = null
//  println(x.length)
//  val aWeirdValue: String = throw new NullPointerException

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No Int for you")
    else 42

  val potentialFail =
    try {
      // code that might fail
      getInt(true)
    } catch {
      case e: RuntimeException => println("Caught a RuntimeException")
    } finally {
      // code that will get executed no matter what
      // optional
      // does not influence the return type of this expressions; used for side effects e.g. logging
      println("Finally")
    }

  class MyException extends Exception
  val exception = new MyException
}
