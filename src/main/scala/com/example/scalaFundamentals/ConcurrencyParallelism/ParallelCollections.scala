package com.example.scalaFundamentals.ConcurrencyParallelism
import java.util.concurrent.ForkJoinPool
import scala.collection.parallel.ForkJoinTaskSupport

object ParallelCollections {
  def ParallelCollections(): Unit = {
    //Converting Sequential Collections to Parallel
    val numbers = (1 to 10).toList
    val parNumbers = numbers.par  // Convert to parallel collection
    println(parNumbers.map(_ * 2)) // Each element is processed in parallel

    //Performance Gains & When to Use Parallel Collections
    val largeList = (1 to 1000000).toList
    val start1 = System.nanoTime()
    largeList.map(_ * 2)  // Sequential execution
    println(s"Sequential Time: ${(System.nanoTime() - start1) / 1e6} ms")

    val start2 = System.nanoTime()
    largeList.par.map(_ * 2)  // Parallel execution
    println(s"Parallel Time: ${(System.nanoTime() - start2) / 1e6} ms")

    //Parallel Operations (map, reduce, fold, aggregate)
    //Parallel map and filter
    val nums = (1 to 10).par
    val doubled = nums.map(_ * 2)  // All elements are doubled in parallel
    val evens = nums.filter(_ % 2 == 0)  // Parallel filtering

    //Parallel reduce
    val sum = (1 to 1000).par.reduce(_ + _)
    println(sum) // Sum of numbers from 1 to 1000 (computed in parallel)

    //Parallel fold (With Initial Value)
    val sumWithInitial = (1 to 1000).par.fold(10)(_ + _)
    println(sumWithInitial) // Adds 10 as an initial value

    //Aggregate (For Custom Parallel Reductions)
    val result = (1 to 100).par.aggregate(0)(_ + _, _ + _)
    println(result)  // Parallel sum with an initial value

    //Thread Management in Parallel Collections
    //Customizing the Number of Threads
    val myList = (1 to 10000).toList.par
    myList.tasksupport = new ForkJoinTaskSupport(new ForkJoinPool(4))  // Set 4 threads

    println(myList.map(_ * 2))  // Parallel execution with 4 threads


  }

}
