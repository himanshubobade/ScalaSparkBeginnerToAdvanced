package com.example.scalaFundamentals.FunctionalProgramming
import scala.util.{Try, Success, Failure}

object MonadsForComprehensions {
  def MonadsForComprehensions(): Unit = {
    //Left Identity
    Some(3).flatMap(x => Some(x * 2)) == Some(3 * 2) // true

    //Right Identity
    Some(3).flatMap(x => Some(x)) == Some(3) // true

    //Associativity
    val f = (x: Int) => Some(x * 2)
    val g = (y: Int) => Some(y + 1)
    Some(3).flatMap(f).flatMap(g) == Some(3).flatMap(x => f(x).flatMap(g)) // true

    //Option Monad
    val maybeNumber: Option[Int] = Some(10)
    val result1 = maybeNumber.map(_ * 2)  // Some(20)
    val flatResult = maybeNumber.flatMap(x => Some(x * 2))  // Some(20)

    //Try Monad
    val safeDivide = (x: Int, y: Int) => Try(x / y)
    val result2 = safeDivide(10, 2).map(_ * 2)  // Success(10)
    val failure1 = safeDivide(10, 0)            // Failure(java.lang.ArithmeticException)

    //Either Monad
    val divide = (x: Int, y: Int) => if (y == 0) Left("Cannot divide by zero") else Right(x / y)
    val result3 = divide(10, 2).map(_ * 2)  // Right(10)
    val failure2 = divide(10, 0)            // Left("Cannot divide by zero")

    //Basic Example (Without For-Comprehension)
    val a = Some(10)
    val b = Some(2)
    val result4 = a.flatMap(x => b.map(y => x / y)) // Some(5)

    //Using For-Comprehension
    val result5 = for {
      x <- Some(10)
      y <- Some(2)
    } yield x / y  // Some(5)

    //Using For-Comprehensions with Different Monads
    // Handling Option

    val result6 = for {
      x <- Some(10)
      y <- Some(5)
    } yield x + y
    println(result6)  // Some(15)

    //Handling Try
    val result7 = for {
      x <- Try(10 / 2)
      y <- Try(20 / 0)  // Division by zero!
    } yield x + y
    println(result7)  // Failure(java.lang.ArithmeticException)

    //Handling Either
    val result8 = for {
      x <- Right(10)
      y <- Right(2)
    } yield x / y

    println(result8)  // Right(5)

    //Chaining Filters in For-Comprehensions
    val result9 = for {
      x <- Some(10) if x > 5
      y <- Some(2)  if y != 0
    } yield x / y

    println(result9)  // Some(5)


  }

}
