ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.10"

val sparkVersion = "3.1.2"
val akkaVersion = "2.6.21"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaBasics",
    // Define merge strategy
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case "reference.conf"              => MergeStrategy.concat
      case _                              => MergeStrategy.first
    }
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql"  % sparkVersion,
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test
)

// Import sbt-assembly plugin settings
enablePlugins(AssemblyPlugin)

// Define sbt-assembly settings
assembly / assemblyJarName := "ScalaBasics.jar"
