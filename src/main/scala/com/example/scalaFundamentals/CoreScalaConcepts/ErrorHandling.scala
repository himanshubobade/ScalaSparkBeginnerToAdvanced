package com.example.scalaFundamentals.CoreScalaConcepts

object ErrorHandling {
  def ErrorHandling(): Unit = {
    //Option, Some, and None
    def findUser(id: Int): Option[String] = {
      if (id == 1) Some("Alice") else None
    }

    val user1 = findUser(1)
    val user2 = findUser(2)

    println(user1)  // Output: Some(Alice)
    println(user2)  // Output: None

    // Handling Option Value
    val user = findUser(2).getOrElse("Unknown")
    println(user)  // Output: Unknown

    //Using map to Transform Option Values

    val length = findUser(1).map(_.length)
    println(length)  // Output: Some(5)
    // Using flatMap (Chaining)

    def findEmail(name: String): Option[String] =
      if (name == "Alice") Some("alice@example.com") else None

    val email = findUser(1).flatMap(findEmail)
    println(email)  // Output: Some(alice@example.com)
    //Using filter to Apply Conditions

    val validUser = findUser(1).filter(_.startsWith("A"))
    println(validUser)  // Output: Some(Alice)

    val invalidUser = findUser(1).filter(_.startsWith("B"))
    println(invalidUser)  // Output: None
    //Using match for Pattern Matching

    findUser(1) match {
      case Some(name) => println(s"User found: $name")
      case None       => println("User not found")
    }

    //Try, Success, and Failure (Exception Handling in Functional Style)


    import scala.util.{Failure, Success, Try}

    def divide(a: Int, b: Int): Try[Int] = Try(a / b)

    val result1 = divide(10, 2)  // Success(5)
    val result2 = divide(10, 0)  // Failure(java.lang.ArithmeticException: / by zero)

    println(result1)  // Output: Success(5)
    println(result2)  // Output: Failure(java.lang.ArithmeticException: / by zero)

    //Handling Try Values
    //Using getOrElse (Default Value)

    val safeResult = divide(10, 0).getOrElse(-1)
    println(safeResult)  // Output: -1

    //Using map to Transform Try

    val doubled = divide(10, 2).map(_ * 2)
    println(doubled)  // Output: Success(10)

    //Using flatMap (Chaining)

    def safeInverse(x: Int): Try[Double] = Try(1.0 / x)

    val result = divide(10, 2).flatMap(safeInverse)
    println(result)  // Output: Success(0.2)

    //Using recover (Handling Errors Gracefully)

    val safeDiv1 = divide(10, 0).recover {
      case _: ArithmeticException => -1
    }
    println(safeDiv1)  // Output: Success(-1)

    //Using recoverWith (Returning Another Try)
    val safeDiv2 = divide(10, 0).recoverWith {
      case _: ArithmeticException => Try(10)
    }
    println(safeDiv2)  // Output: Success(10)

    //Using match for Pattern Matching

    divide(10, 0) match {
      case Success(value) => println(s"Result: $value")
      case Failure(ex)    => println(s"Error: ${ex.getMessage}")
    }

  }

}
