ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

lazy val root = (project in file("."))
  .settings(
    name := "flink-scala3-csv",
    idePackagePrefix := Some("org.acme")
  )

libraryDependencies += "org.apache.flink" % "flink-streaming-java" % "1.16.0" % "provided"
libraryDependencies += "org.apache.flink" % "flink-clients" % "1.16.0" % "provided"
libraryDependencies += "org.apache.flink" % "flink-table-planner-loader" % "1.16.0" % "provided"
libraryDependencies += "org.apache.flink" % "flink-table-common" % "1.16.0" % "provided"
libraryDependencies += "org.apache.flink" % "flink-table-api-java" % "1.16.0" % "provided"
libraryDependencies += "org.apache.flink" % "flink-table-api-java-bridge" % "1.16.0" % "provided"
libraryDependencies += "org.apache.flink" % "flink-table-runtime" % "1.16.0" % "provided"
libraryDependencies += "org.apache.flink" % "flink-connector-files" % "1.16.0" % "provided"
libraryDependencies += "org.apache.flink" % "flink-csv" % "1.16.0" % "provided"

