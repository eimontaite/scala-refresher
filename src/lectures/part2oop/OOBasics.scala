package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Aiste", 29)
  println(person.age)
  println(person.x)
  person.greet("Andrius")

  val anotherPerson = new Person ("bb")
  println(s"${anotherPerson.name}, ${anotherPerson.age}")

  val thirdPerson = new Person ()
  println(s"${thirdPerson.name}, ${thirdPerson.age}")

}

// name and age are class parameters, not class members (fields).
// you can add val before to turn them into fields
class Person(val name: String, val age: Int) {
  // body - contains fields and functions
  val x = 2

  def greet(name: String): Unit = {
    println(s"${this.name} says: Hi, $name")
  }

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple or overloading constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}
