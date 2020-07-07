package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  // use recursion when you need loops
  def aRepeatedFunction(aString: String, anInt: Int): String = {
    if (anInt == 1) aString
    else aString + aRepeatedFunction(aString,  anInt - 1)
  }

  println(aRepeatedFunction("hello", 2))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = {
      a + b
    }

    aSmallerFunction(n, n + 1)
  }

  println(aBigFunction(3))

  def greeting(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old"
  }

  println(greeting("Aiste", 29))

  def factorial(num: Int): Int = {
    if (num == 1) num * 1
    else num * factorial(num - 1)
  }

  println(factorial(10))

  def fibonacci(num: Int): Int = {
    if (num <= 1) num
    else fibonacci(num - 1) + fibonacci(num - 2)

  }
  println(fibonacci(7))


  def isPrime(num: Int): Boolean = {
    def hasDivisors(d: Int): Boolean =
      if (d <= 1) true
      else num % d != 0 && hasDivisors(d - 1)

      hasDivisors(num / 2)
    
  }

  println(isPrime(18))


}
