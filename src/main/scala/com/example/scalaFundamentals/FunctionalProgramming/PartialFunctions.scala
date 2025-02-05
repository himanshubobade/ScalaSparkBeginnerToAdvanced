package com.example.scalaFundamentals.FunctionalProgramming

object PartialFunctions {
  def PartialFunctions(): Unit = {
    //Creating a Partial Function
    val divideByTwo1: PartialFunction[Int, Int] = {
      case x if x % 2 == 0 => x / 2
    }
    println(divideByTwo1(4))  // Output: 2
    println(divideByTwo1(6))  // Output: 3
    println(divideByTwo1(5))  // ERROR: MatchError!

    //Checking If a Partial Function is Defined
    println(divideByTwo1.isDefinedAt(4))  // Output: true
    println(divideByTwo1.isDefinedAt(5))  // Output: false

    val num = 5
    if (divideByTwo1.isDefinedAt(num)) println(divideByTwo1(num))
    else println(s"Function not defined for $num")

    //Handling Multiple Cases in Partial Functions
    val divideByTwo2: PartialFunction[Int, Int] = {
      case x if x % 2 == 0 => x / 2
    }

    val fallback: PartialFunction[Int, String] = {
      case x => s"$x is not even"
    }

    val combined = divideByTwo2 orElse fallback

    println(combined(4))  // Output: 2
    println(combined(5))  // Output: "5 is not even"

    //Using Partial Functions with collect
    val numbers = List(1, 2, 3, 4, 5, 6)
    val divideEvenNumbers: PartialFunction[Int, Int] = {
      case x if x % 2 == 0 => x / 2
    }

    val result = numbers.collect(divideEvenNumbers)
    println(result)  // Output: List(1, 2, 3)

    // Diff btw map and collect
    val nums = List(1, 2, 3, 4, 5, 6)

    val halfEvens = nums.collect {
      case x if x % 2 == 0 => x / 2
    }

    println(halfEvens)  // Output: List(1, 2, 3)

  }

}
