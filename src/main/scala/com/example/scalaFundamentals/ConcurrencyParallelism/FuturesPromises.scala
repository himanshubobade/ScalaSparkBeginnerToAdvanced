package com.example.scalaFundamentals.ConcurrencyParallelism
import scala.concurrent.{Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}
import scala.concurrent.Await
import scala.concurrent.duration._


object FuturesPromises {
  def FuturesPromises(): Unit = {

    //Future
    val f: Future[Int] = Future {
      Thread.sleep(1000)  // Simulate a long-running task
      42                  // The result of the computation
    }

    //Handling future list
    f.onComplete {
      case Success(value) => println(s"Computation completed with: $value")
      case Failure(exception) => println(s"Computation failed with: ${exception.getMessage}")
    }
    val f21: Future[Int] = f.map(_ * 2)  // Doubles the result if successful
    val f3: Future[String] = f.flatMap(x => Future(s"Result: $x"))
    val safeFuture1: Future[Int] = f.recover {
      case _: ArithmeticException => 0
    }
    //Multiple futures
    val f1 = Future { 10 }
    val f22 = Future { 20 }

    val result1 = for {
      a <- f1
      b <- f22
    } yield a + b

    result1.onComplete {
      case Success(value) => println(s"Sum: $value")
      case Failure(exception) => println(s"Error: ${exception.getMessage}")
    }

    //Future sequnce parallel execution
    val futuresList = List(Future(10), Future(20), Future(30))
    val combinedFuture: Future[List[Int]] = Future.sequence(futuresList)

    //Future Timeouts & Fallbacks
    val safeFuture2 = f.recoverWith {
      case _: Exception => Future.successful(0)
    }
    val fastFuture = Future { Thread.sleep(500); "Fast" }
    val slowFuture = Future { Thread.sleep(2000); "Slow" }

    val first = Future.firstCompletedOf(Seq(fastFuture, slowFuture))

    //Promises
    val promise = Promise[Int]()
    val future = promise.future  // Extract Future from Promise

    // Completing the promise (in another thread)
    Future {
      Thread.sleep(1000)
      promise.success(42)  // or promise.failure(new Exception("Error"))
    }

    //Blocking future
    val result2 = Await.result(f, 2.seconds)  // Blocks the thread
    println(result2)

  }

}
