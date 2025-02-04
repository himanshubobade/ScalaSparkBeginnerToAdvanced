package com.example.scalaFundamentals.CoreScalaConcepts

object HOF_ClosuresCurrying {
  def HOF_ClosuresCurrying(): Unit = {

    ////////////////HOF///////////////////////

    //normal function
    def add1(x: Int, y: Int): Int = {
      x+y
    }
    println(add1(3,5))

    // w/o parameters
    def greet1(): String = "Hello, Scala!"
    println(greet1())  // Output: "Hello, Scala!"

    def greet2 = "Hello, Scala!"  // No `()`
    println(greet2)  // Output: "Hello, Scala!"

    // Default parameters
    def greet3(name: String = "Guest"): String = s"Hello, $name!"

    println(greet3())         // Output: "Hello, Guest!"
    println(greet3("Alice"))  // Output: "Hello, Alice!"

    // Named Parameters
    def formatText(text: String, uppercase: Boolean): String = {
      if (uppercase) text.toUpperCase else text.toLowerCase
    }

    println(formatText("Scala", uppercase = true))  // Output: "SCALA"
    println(formatText(uppercase = false, text = "Scala"))  // Named Arguments

    // Variable Argument Function varargs
    def sum(numbers: Int*): Int = numbers.sum
    println(sum(1, 2, 3, 4, 5))  // Output: 15

    // Lambda Expression
    val square = (x: Int) => x * x
    println(square(4))  // Output: 16

    ///////// HIGH ORDER FUNCTION //////////
    def operate(x: Int, y: Int, func: (Int, Int) => Int): Int = func(x, y)

    val add2 = (a: Int, b: Int) => a + b
    val multiply = (a: Int, b: Int) => a * b

    println(operate(3, 5, add2))      // Output: 8
    println(operate(3, 5, multiply)) // Output: 15

    ///

    def multiplier3(factor: Int): Int => Int = (x: Int) => x * factor

    val triple = multiplier3(3)
    println(triple(5))  // Output: 15

    // Built in HOF
    val numbers = List(1, 2, 3, 4)
    val squared = numbers.map(x => x * x)

    println(squared)  // Output: List(1, 4, 9, 16)

    val evenNumbers = numbers.filter(_ % 2 == 0)
    println(evenNumbers)  // Output: List(2, 4)

    val sum2 = numbers.reduce((a, b) => a + b)
    println(sum2)  // Output: 10

    val sumShort = numbers.reduce(_ + _)
    println(sumShort)  // Output: 10

    val sumWithInitial = numbers.fold(10)(_ + _)
    println(sumWithInitial)  // Output: 20

    numbers.foreach(x => println(s"Number: $x"))

//////////////////// Closure and currying /////////////////////

    var externalVariable = 10  // Free variable

    val closureFunction = (x: Int) => x + externalVariable

    println(closureFunction(5))  // Output: 15

    externalVariable = 20
    println(closureFunction(5))  // Output: 25

    //Immutable Closure (Final Variable)

    val fixedValue = 100  // Immutable free variable

    val addFixed = (x: Int) => x + fixedValue
    println(addFixed(10))  // Output: 110

    //Mutable Closure
    var changingValue = 5

    val multiply1 = (x: Int) => x * changingValue
    println(multiply1(3))  // Output: 15

    changingValue = 10
    println(multiply1(3))  // Output: 30

    //Closures Inside Higher-Order Functions
    def createAdder(y: Int) = (x: Int) => x + y

    val addFive = createAdder(5)
    println(addFive(10))  // Output: 15

    //Curried Function

    def curriedAdd(a: Int)(b: Int): Int = a + b
    println(curriedAdd(2)(3))  // Output: 5

    //Partial Application Using Currying

    val addTen = curriedAdd(10) _  // Partially applied function
    println(addTen(5))  // Output: 15

    //Converting a Normal Function to a Curried Function

    val normalAdd = (a: Int, b: Int) => a + b
    val curriedFunction = normalAdd.curried

    println(curriedFunction(2)(3))  // Output: 5

    //Currying with Higher-Order Functions

    def multiplier(factor: Int)(value: Int): Int = factor * value

    val double = multiplier(2) _
    println(double(5))  // Output: 10

    val triple1 = multiplier(3) _
    println(triple1(5))  // Output: 15

    //Using Currying with foldLeft

    val numbers3 = List(1, 2, 3, 4)

    val sum3 = numbers3.foldLeft(0)(_ + _)
    println(sum3)  // Output: 10




  }

}
