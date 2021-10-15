name := "vigil-scala-challenge"

version := "0.1"

scalaVersion := "2.13.6"

val akkaVersion = "2.6.16"
val akkaHttpVersion = "10.2.6"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
)