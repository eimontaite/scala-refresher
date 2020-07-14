package lectures.part2oop

object Objects extends App {
  // Scala does not have class-level functionality ("static")
  // object is a singleton instance; type + only instance
  // "static" / "class" level functionality
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  // instance level functionality
  class Person(val name: String) {

  }

  val mary = new Person("Mary")
  val john = new Person("John")
  val bobby = Person(mary, john)

  // Scala application is a Scala object with
  // def main(args: Array[String]): Unit implemented

  println(Person.N_EYES)
}
