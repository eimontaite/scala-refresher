package lectures.part2oop

object Notations extends App {
  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  // infix notation - operator notation (syntactic sugar)
  println(mary likes "Inception")
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)

  // all operators are methods
  println(1 + 2)
  println(1.+(2))

  // prefix notation
  val x = -1 // equivalent to 1.unary_-
  val y = 1.unary_-
  // unary_ only works with - _ ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())
}
