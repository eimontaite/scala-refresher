package exercises

object NotationsExercises extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int = 42) {
    def +(nickname: String): Person = new Person(s"${this.name} ($nickname)", this.favoriteMovie)
    def unary_+ : Person = new Person(s"${this.name}", this.favoriteMovie, this.age + 1)
    def learns(subject: String): String = s"${this.name} is learning $subject"
    def learnsScala: String = learns("Scala")
    def apply(times: Int): String = s"$name watched their favorite movie $favoriteMovie $times time(s)"
  }

  val mary = new Person("Mary", "Inception") + "the rock"
  println(mary.name)
  val olderMary = +mary
  println(olderMary.age)
  println(mary.learns("to ride a bike"))
  println(mary.learnsScala)
  println(mary.apply(3))
}
