package com.example.scalaFundamentals.CoreScalaConcepts

import scala.collection.mutable.ListBuffer

object collections {
  def collections(): Unit = {
    // Immutable Collections
    val numbers1 = List(1, 2, 3, 4)
    val newNumbers = numbers1 :+ 5  // Adds 5 to the list, creates a new list

    println(numbers1)      // Output: List(1, 2, 3, 4)  (Original remains unchanged)
    println(newNumbers)   // Output: List(1, 2, 3, 4, 5)

    //Mutable Collections
    val numbers2 = ListBuffer(1, 2, 3, 4)
    numbers2 += 5  // Modifies in place

    println(numbers2)  // Output: ListBuffer(1, 2, 3, 4, 5)

    //Immutable List
    val numbers3 = List(1, 2, 3, 4, 5)
    val filteredNumbers = numbers3.filterNot(_ == 3)

    println(filteredNumbers)  // Output: List(1, 2, 4, 5)

    // transforming collections
    val numbers4 = List(1, 2, 3)
    val squared = numbers4.map(x => x * x)

    println(squared)  // Output: List(1, 4, 9)

    val words = List("Hello", "Scala")
    val chars = words.flatMap(_.toList)

    println(chars)  // Output: List(H, e, l, l, o, S, c, a, l, a)

    val numbers5 = List(1, 2, 3, 4, 5)
    val evens = numbers5.filter(_ % 2 == 0)

    println(evens)  // Output: List(2, 4)

    //Aggregation Operations (reduce, fold, sum)
    val numbers6 = List(1, 2, 3, 4)
    val sum = numbers6.reduce(_ + _)

    println(sum)  // Output: 10

    val sumWithInitial = numbers6.fold(10)(_ + _)
    println(sumWithInitial)  // Output: 20

    // Lists
    val list = List(1, 2, 3, 4, 5)
    println(list.head)  // Output: 1
    println(list.tail)  // Output: List(2, 3, 4, 5)
    println(list.reverse)  // Output: List(5, 4, 3, 2, 1)

    // Sets
    val set = Set(1, 2, 3, 3)
    println(set)  // Output: Set(1, 2, 3)

    // Maps
    val map = Map("Alice" -> 25, "Bob" -> 30)
    println(map("Alice"))  // Output: 25

    // Mutable Map
    import scala.collection.mutable.Map

    val mutableMap = Map("Alice" -> 25)
    mutableMap += ("Bob" -> 30)

    println(mutableMap)  // Output: Map(Alice -> 25, Bob -> 30)

    //Tuples
    val person = ("Alice", 25)
    println(person._1)  // Output: Alice
    println(person._2)  // Output: 25

    //Arrays
    val arr = Array(1, 2, 3, 4)
    arr(0) = 10  // Modifying element
    println(arr.mkString(", "))  // Output: 10, 2, 3, 4

  }
}
