package com.example

import com.example.scalaFundamentals.CoreScalaConcepts.operatorloops
import org.apache.spark.sql.SparkSession
object M {
  def main(args: Array[String]): Unit = {
    println("Hello world object!")
//    if (args.length < 1) {
//      println("Usage: SparkSubmitExample <input-file>")
////      sys.exit(1)
//    }

    // Initialize SparkSession
    val master = if (args.nonEmpty) args(0) else "local[*]"
    val spark = SparkSession.builder()
      .appName("SparkSubmitExample")
      .master(master)
      .getOrCreate()

    println("I read till here")

    operatorloops.operatorloops()
    //readwrite.readwrite(spark)

  }
}