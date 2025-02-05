package com.example

import com.example.scalaFundamentals.ConcurrencyParallelism.AkkaActorsModel.{AkkaActorsModelBasic, AkkaActorsModelReply, AkkaActorsModelStopActor}
import com.example.scalaFundamentals.ConcurrencyParallelism.{FuturesPromises, ParallelCollections}
import com.example.scalaFundamentals.CoreScalaConcepts.{ErrorHandling, HOF_ClosuresCurrying, LazyEvaluation, collections, operatorloops}
import com.example.scalaFundamentals.FunctionalProgramming.{MapFlatMapFilterReduceFoldScan, MonadsForComprehensions, PureFunctionsReferentialTransparency}
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

    //operatorloops.operatorloops()
    //readwrite.readwrite(spark)
    //HOF_ClosuresCurrying.HOF_ClosuresCurrying()
    //collections.collections()
    //ErrorHandling.ErrorHandling()
    //LazyEvaluation.LazyEvaluation()
    //PureFunctionsReferentialTransparency.PureFunctionsReferentialTransparency()
    //MapFlatMapFilterReduceFoldScan.MapFlatMapFilterReduceFoldScan()
    //PureFunctionsReferentialTransparency.PureFunctionsReferentialTransparency()
    //MonadsForComprehensions.MonadsForComprehensions()
    //FuturesPromises.FuturesPromises()
    //AkkaActorsModelBasic.AkkaActorsModelBasic()
    //AkkaActorsModelStopActor.AkkaActorsModelStopActor()
    //AkkaActorsModelReply.AkkaActorsModelReply()
    ParallelCollections.ParallelCollections()

  }
}