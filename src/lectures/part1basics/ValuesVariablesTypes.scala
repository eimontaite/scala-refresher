package lectures.part1basics

object ValuesVariablesTypes extends App {

  // vals are immutable
  val x: Int = 42;
  println(x);

  val aString: String = "hello"

  val aBoolean: Boolean = false

  val aChar: Char = 'a'

  val aShort: Short = 1254

  val aLong: Long = 1435496094346L

  val aFloat: Float = 3.0f

  val aDouble: Double = 2.0

  // variables

  var aVariable: Int = 4;

  aVariable = 5; // side effects

}
