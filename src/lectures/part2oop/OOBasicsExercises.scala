package lectures.part2oop

object OOBasicsExercises extends App {
  val author = new Author("Aiste", "Eimontaite", 1991)
  val novel = new Novel("Very novelistic", 2019, author)
  val newNovel = novel.copy(2020)
  println(author.fullName)
  println(novel.isWrittenBy(author))
  println(novel.authorAge)
  println(newNovel.authorAge)

  val counter = new Counter(5)
  counter.increment.increment.increment.print
  counter.decrement.decrement.print
  counter.increment(5).print
  counter.decrement(1).print
}

class Author(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName = this.firstName + this.surname
}

class Novel(name: String, yearOfRelease: Int, author: Author) {
  def authorAge: Int = yearOfRelease - author.yearOfBirth
  def isWrittenBy(author: Author) = if((this.author.fullName == author.fullName) && this.author.yearOfBirth == author.yearOfBirth) true else false
  def copy(newYearOfRelease: Int) = new Novel(this.name, newYearOfRelease, this.author)
}

class Counter(val count: Int) {
  def increment = new Counter(count + 1)
  def decrement = new Counter(count - 1)

  def increment(n: Int): Counter = {
    if (n <= 0) this
    else increment.increment(n - 1)
  }
  def decrement(n: Int): Counter = {
    if (n <= 0) this
    else decrement.decrement(n - 1)
  }

  def print = println(count)

}
