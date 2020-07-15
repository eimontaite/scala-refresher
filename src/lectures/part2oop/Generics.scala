package lectures.part2oop

object Generics extends App {
  class MyList[A] {
    // use the type A inside the class definition
    def add[B >: A](a: B): MyList[B] = ???
    // A - Cat
    // B - Dog <- Animal
    // turns List[Cat] into List[Animal] - covariant list

  }

  class MyMap[key, value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInts = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) = ???

  // 2. List[Cat] and List[Animal] are two separate things = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Not for lists! CONTRAVARIANT
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

}
