package com.example

import org.apache.spark.sql.SparkSession

object readwrite {

  def readwrite(spark: SparkSession): Unit = {
    //####################### INPUT READ   ###########################//
    //######################## Text file  ##########################//

    val inputtextFile = "C:\\Users\\HIMANSHUU\\IdeaProjects\\spark_sbt_setup_CLI_practice\\src\\main\\scala\\com\\example\\assets\\textfile.txt"
    // Read input file
    //val inputFile = args(0)
    val textdata = spark.read.textFile(inputtextFile)
    println(textdata.show())

    //######################## csv file  ##########################//

    val inputcsvFile1 = "C:\\Users\\HIMANSHUU\\IdeaProjects\\spark_sbt_setup_CLI_practice\\src\\main\\scala\\com\\example\\assets\\people-1000.csv"
    val df1 = spark.read.format("csv").option("header","true").load(inputcsvFile1)
    println(df1.show())

    val inputcsvfile2 = "C:\\Users\\HIMANSHUU\\IdeaProjects\\spark_sbt_setup_CLI_practice\\src\\main\\scala\\com\\example\\assets\\customers-1000.csv"
    val df2 = spark.read.format("csv").option("header",true).load(inputcsvfile2)
    println(df2.show())
  }

}
