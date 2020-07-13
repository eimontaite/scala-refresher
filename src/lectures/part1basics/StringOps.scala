package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(2, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // Scala-specific String interpolators
  // S-interpolators
  val name = "Aiste"
  val age = 29
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"

  println(greeting)
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.5f
  val myth = f"$name can eat $speed%2.2f burgers per minute"

  println(myth)

  // raw interpolator
  println(raw"this is a \n newline")
  val escaped = "this is a \n newline"

  println(raw"$escaped")
}
