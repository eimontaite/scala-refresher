package lectures.part2oop

object Inheritance extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"
    def eat: Unit = println("nom nom nom")
  }

  class Cat extends Animal

  val cat = new Cat
  cat.eat
  println(cat.creatureType)

  // constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  sealed class Dog(override val creatureType: String) extends Animal {
//    override val creatureType = "domestic"
    override def eat: Unit = {
      // super
      super.eat
      println("crunch crunch")
    }
  }

  val dog = new Dog("domestic")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // preventing overrides
  // 1 - using "final" on a member
  // 2 - using "final" on the class itself
  // 3 - seal the class: extend classes in this file only and prevent extension in other files



}