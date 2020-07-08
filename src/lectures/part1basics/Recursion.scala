package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(num: Int): Int = {
    if (num == 1) num * 1
    else {
      println(s"Computing factorial of $num - I first need factorial of ${num - 1}")
      val result = num * factorial(num - 1)
      println(s"Computed factorial of $num")

      result
    }
  }

//  println(factorial(14))

  // works with large number
  def anotherFactorial(num: Int): Int = {
    @tailrec
    def factorialHelper(x: Int, acc: Int): Int =
      if (x <= 1) acc
      else factorialHelper(x - 1, x * acc) // tail recursion; uses recursive call as the last expression

    factorialHelper(num, 1)
  }

//  println(anotherFactorial(14)) = factorialHelper(10, 1)
//  = factorialHelper(9, 10 * 1)
//  = factorialHelper(8, 9 * 10 * 1)
//  = factorialHelper (7, 8 * 9 * 10)
//      ...
//  = factorialHelper(1, 1 * 2 * 3 ... * 10)

    @tailrec
    def concatenationTailRec(string: String, int: Int, accumulator: String): String =
    if (int == 0) accumulator
    else concatenationTailRec(string,  int - 1, string + accumulator)


  println(concatenationTailRec("Aiste", 4, ""))

  def isPrime(num: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(d: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (d <= 1) true
      else isPrimeTailRec(d - 1, num % d != 0)

    isPrimeTailRec(num / 2, true)
  }

  println(isPrime(17))

  def fibonacci(num: Int): Int = {
    @tailrec
    def fibonacciTailRec(n: Int, last: Int, nextToLast: Int): Int =
      if (n >= num) last
      else fibonacciTailRec(n + 1, last + nextToLast, last)

    if (num <= 2) 1
    else fibonacciTailRec(2, 1, 1)
  }
  println(fibonacci(10))

}


