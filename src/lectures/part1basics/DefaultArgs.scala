package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def tailRecFactorial(x: Int, acc: Int = 1): Int =
    if (x <= 1) acc
    else tailRecFactorial(x - 1, x * acc) // tail recursion; uses recursive call as the last expression

  val fact10 = tailRecFactorial(10)

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("saving picture")
  savePicture("jpg", 800, 600)
}
