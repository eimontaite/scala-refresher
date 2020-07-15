package exercises

object Exceptions extends App {

  val ADDITION = "addition"
  val SUBTRACTION = "subtraction"
  val MULTIPLICATION = "multiplication"
  val DIVISION = "division"


  class OverflowException extends RuntimeException

  class UnderflowException extends RuntimeException

  class MathCalculationException extends RuntimeException

  class PocketCalculator {

    def getResult(x: Int, y: Int, operator: String): Int = {
      val result = operator match {
        case ADDITION if (x + y) < 0 && x > 0 && y > 0 => throw new OverflowException
        case ADDITION if (x + y) > 0 && x < 0 && y < 0 => throw new UnderflowException
        case ADDITION => x + y
        case SUBTRACTION if (x - y) < 0 && x > 0 && y < 0 => throw new OverflowException
        case SUBTRACTION if (x - y) > 0 && x < 0 && y > 0 => throw new UnderflowException
        case SUBTRACTION => x - y
        case MULTIPLICATION if (x * y) < 0 && x < 0 && y < 0 => throw new OverflowException
        case MULTIPLICATION if (x * y) > 0 && x < 0 && y > 0 => throw new UnderflowException
        case MULTIPLICATION if (x * y) > 0 && x > 0 && y < 0 => throw new UnderflowException
        case MULTIPLICATION => x * y
        case DIVISION if y == 0 => throw new MathCalculationException
        case DIVISION if (x / y) < 0 && x > 0 && y > 0 => throw new OverflowException
        case DIVISION if (x / y) > 0 && x < 0 && y > 0 => throw new UnderflowException
        case DIVISION if (x / y) > 0 && x > 0 && y < 0 => throw new UnderflowException
        case DIVISION => x / y
      }
      println(result)
      result
    }

    def add(x: Int, y: Int): Int = getResult(x, y, ADDITION)

    def subtract(x: Int, y: Int): Int = getResult(x, y, SUBTRACTION)

    def multiply(x: Int, y: Int): Int = getResult(x, y, MULTIPLICATION)

    def divide(x: Int, y: Int): Int = getResult(x, y, DIVISION)

  }

  val calc = new PocketCalculator
  calc.add(2147483647, 999999)
}
