package com.example.scalaFundamentals.FunctionalProgramming

object MapFlatMapFilterReduceFoldScan {
  def MapFlatMapFilterReduceFoldScan(): Unit = {

    /// Map
    val numbers = List(1, 2, 3, 4, 5)
    val squared = numbers.map(x => x * x)
    println(squared)  // Output: List(1, 4, 9, 16, 25)

    val words1 = List("Scala", "Spark", "BigData")
    val wordLengths = words1.map(_.length)
    println(wordLengths)  // Output: List(5, 5, 7)

    //Flatmap
    val sentences = List("Hello World", "Scala is great")
    val words2 = sentences.flatMap(sentence => sentence.split(" "))
    println(words2)  // Output: List(Hello, World, Scala, is, great)

    //Difference Between map and flatMap

    val numbers1 = List(1, 2, 3)
    val mapped = numbers1.map(x => List(x, x * 2))
    println(mapped)  // Output: List(List(1, 2), List(2, 4), List(3, 6))

    val flatMapped = numbers1.flatMap(x => List(x, x * 2))
    println(flatMapped)  // Output: List(1, 2, 2, 4, 3, 6)

    //Filter
    val numbers2 = List(1, 2, 3, 4, 5, 6)
    val evenNumbers = numbers2.filter(_ % 2 == 0)
    println(evenNumbers)  // Output: List(2, 4, 6)

    val words = List("Scala", "Spark", "Python", "BigData")
    val longWords = words.filter(_.length > 5)
    println(longWords)  // Output: List(Python, BigData)

    //reduce
    val numbers3 = List(1, 2, 3, 4, 5)
    val sum1 = numbers3.reduce((a, b) => a + b)
    println(sum1)  // Output: 15

    val maxNum = numbers3.reduce((a, b) => if (a > b) a else b)
    println(maxNum)  // Output: 5

    //fold
    val numbers4 = List(1, 2, 3, 4, 5)
    val sum2 = numbers4.fold(10)(_ + _)  // Initial value is 10
    println(sum2)  // Output: 25

    val product = numbers4.fold(1)(_ * _)
    println(product)  // Output: 120

    //Difference Between reduce and fold

    val emptyList = List[Int]()
    //val sumReduce = emptyList.reduce(_ + _)  // ERROR: Throws exception
    val sumFold = emptyList.fold(0)(_ + _)  // Output: 0

    //Scan
    val numbers5 = List(1, 2, 3, 4, 5)
    val scanSum = numbers5.scan(0)(_ + _)
    println(scanSum)  // Output: List(0, 1, 3, 6, 10, 15)

    val factorials = (1 to 5).scan(1)(_ * _)
    println(factorials)  // Output: List(1, 1, 2, 6, 24, 120)


  }

}
