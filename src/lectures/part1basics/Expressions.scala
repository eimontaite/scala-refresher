package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2
  println(x)

  println(2 + 3 * 5)

  println(1 == x)

  println (1 != x)

  println(!(1 == x))

  var aVariable = 2
  aVariable += 3
  println(aVariable)

  // instructions (DO) vs expressions (VALUE)

  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // if expression

  println(aConditionedValue)

  // everything in Scala is an expression!

  // examples of side effects: println(), whiles, reassigning - Units

  // code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  val anotherBlock = {
    2 > 3
  }

  println(aCodeBlock)
  println(anotherBlock)
}
