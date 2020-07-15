package lectures.part2oop

object CaseClasses extends App {
  // 1. class parameters are promoted to fields
  // 2. sensible toString: println(instance) = println(instance.toString)
  // 3. equals and hashCode implemented out of the box - useful in Collections
  // 4. case classes have a handy copy method
  // 5. case classes have companion objects
  // 6. case classes are serializable: Akka
  // 7. case classes have extractor patterns, can be used in pattern matching
  case class Person(name: String, age: Int)

  val thePerson = Person
  val mary = Person("Mary", 33)

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

}
