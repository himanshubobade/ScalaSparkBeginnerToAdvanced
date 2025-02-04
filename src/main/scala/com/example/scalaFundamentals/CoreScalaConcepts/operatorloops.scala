package com.example.scalaFundamentals.CoreScalaConcepts

import scala.annotation.tailrec
import scala.util.control.Breaks._


object operatorloops {
  def operatorloops(): Unit = {

    // variables and data types

    val numbers = scala.collection.mutable.ListBuffer(1,2,3)
    numbers += 4
    println(numbers)

    var  nums = List(1,2,3)
    nums = nums :+ 4
    println(nums)

    val a1 = true
    val b1 = false
    println(a1 && b1)  // false
    println(a1 || b1)  // true
    println(!a1)

    val a = 5
    val b = 3
    println(a & b)  // Output: 1 (0001)
    println(a | b)  // Output: 7 (0111)
    println(a ^ b)  // Output: 6 (0110)
    println(~a)     // Output: -6
    println(a << 2) // Output: 20
    println(a >> 2)

    val a2 = 10
    val b2 = 20
    val max = if (a2>b2) a2 else b2
    println(max)

    // loops

    for (i<- 1 to 5){
      println(i)
    }

    for (i<-1 until 5){
      println(i)
    }

    for (i <- 1 to 10 if i % 2 == 0) {
      println(s"Even number: $i")
    }

    /// for yield

    val squares = for (i<-1 to 5) yield i * 1
    println(squares)

    // for loop

    for (i <- 1 to 3; j <- 1 to 2) {
      println(s"i: $i, j: $j")
    }

    /// while

    var x = 5
    while (x > 0) {
      println(s"Countdown: $x")
      x -= 1
    }

    //// do while

    var y = -10
    do {
      println(s"Countdown: $y")
      y -= 1
    } while (y > 0)

    /// break

    breakable {
      for (i <- 1 to 10) {
        if (i == 5) break  // Exits loop at i == 5
        println(s"i: $i")
      }
    }

    // recursion

    def factorial(n: Int): Int = {
      if (n <= 1) 1
      else n * factorial(n - 1)
    }

    println(factorial(5))  // Output: 120

    /// tailrec recusion optimization
    @tailrec
    def factorialTR(n: Int, acc: Int = 1): Int = {
      if (n <= 1) acc
      else factorialTR(n - 1, n * acc)
    }

    println(factorialTR(5))  // Output: 120

    //// pattern matching

    val number = 2

    val result = number match {
      case 1 => "One"
      case 2 => "Two"
      case 3 => "Three"
      case _ => "Unknown"  // Default case
    }

    println(result)  // Output: "Two"

    // conditional matching
    val day = "Monday"

    day match {
      case "Monday" | "Tuesday" | "Wednesday" => println("Weekday")
      case "Saturday" | "Sunday" => println("Weekend")
      case _ => println("Invalid day")
    }

    // with guards

    val num = 10

    num match {
      case x if x > 0 => println("Positive number")
      case x if x < 0 => println("Negative number")
      case _ => println("Zero")
    }

    // type matching

    def identifyType(x: Any): String = x match {
      case i: Int => "It's an Integer"
      case s: String => "It's a String"
      case b: Boolean => "It's a Boolean"
      case _ => "Unknown type"
    }

    println(identifyType(42))       // Output: "It's an Integer"
    println(identifyType("Scala"))  // Output: "It's a String"

    // Case class
    case class Person(name: String, age: Int)

    val person = Person("Alice", 25)

    person match {
      case Person("Alice", 25) => println("Matched Alice!")
      case Person(name, age) => println(s"Person: $name, Age: $age")
    }

    // List and sequences
    val numbers1 = List(1, 2, 3)

    numbers1 match {
      case Nil => println("Empty list")
      case x :: Nil => println(s"Single element: $x")
      case x :: y :: Nil => println(s"Two elements: $x and $y")
      case x :: xs => println(s"Head: $x, Tail: $xs")  // Head-Tail decomposition
    }

    // Tuples

    val tuple = (10, "Scala")

    tuple match {
      case (10, "Scala") => println("Exact Match!")
      case (x, y) => println(s"Tuple values: $x and $y")
    }

    // Option

    val someValue: Option[Int] = Some(10)
    val noValue: Option[Int] = None

    someValue match {
      case Some(v) => println(s"Value is $v")
      case None => println("No value present")
    }

    // func programming

    val people = List(("Alice", 25), ("Bob", 30))

    for ((name, age) <- people) {
      println(s"Name: $name, Age: $age")
    }

  }
}
