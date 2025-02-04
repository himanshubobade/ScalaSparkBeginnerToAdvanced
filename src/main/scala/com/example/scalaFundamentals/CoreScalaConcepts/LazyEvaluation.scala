package com.example.scalaFundamentals.CoreScalaConcepts

object LazyEvaluation {
  def LazyEvaluation(): Unit = {
    lazy val x = {
      println("Computing x...")
      10
    }

    println("Before accessing x")
    println(x)  // "Computing x..." printed now
    println(x)  // No recomputation, just prints 10

    //Creating a Lazy Infinite Sequence

    val lazyNums: Stream[Int] = Stream.from(1)  // Infinite sequence
    println(lazyNums.take(5).toList)  // Output: List(1, 2, 3, 4, 5)

    //Lazy Fibonacci Sequence (Recursive)

    def fib(a: Int, b: Int): Stream[Int] = a #:: fib(b, a + b)

    val fibSeq = fib(0, 1)
    println(fibSeq.take(10).toList)
    // Output: List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)

    //Lazy Evaluation with Functions (by-name parameters)

    def compute1(x: => Int): Int = {
      println("Inside function")
      x + x  // Computation happens twice
    }

    println("Before calling compute")
    val result1 = compute1({
      println("Computing x...")
      10
    })
    println(result1)

    //Repeated computation fixation
    def compute2(x: => Int): Int = {
      println("Inside function")
      lazy val y = x  // Cached after first evaluation
      y + y
    }

    println("Before calling compute")
    val result2 = compute2({
      println("Computing x...")
      10
    })
    println(result2)




  }

}
