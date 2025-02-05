package com.example.scalaFundamentals.FunctionalProgramming

object PureFunctionsReferentialTransparency {
  def PureFunctionsReferentialTransparency(): Unit = {
    // Pure Function
    def add(a: Int, b: Int): Int = a + b

    // Calling add(2, 3) will always return 5.
    println(add(2, 3))  // Output: 5

    //Impure Function
    var counter = 0

    def impureAdd(a: Int, b: Int): Int = {
      counter += 1          // Modifies external state
      a + b
    }

    println(impureAdd(2, 3))  // Output: 5, but counter changes from 0 to 1

    // Referential Transparency
    //Pure Function
    def multiply(x: Int, y: Int): Int = x * y

    val result1 = multiply(3, 4)
    val result2 = multiply(3, 4)

    // You can replace 'multiply(3, 4)' with 12 anywhere in your code.
    println(result1)  // Output: 12
    println(result2)  // Output: 12

    //Without Referential Transparency
    var randomValue = scala.util.Random.nextInt(100)

    def getRandom: Int = randomValue

    println(getRandom)  // Might output, say, 42

  }

}
