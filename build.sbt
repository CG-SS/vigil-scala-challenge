name := "vigil-scala-challenge"

version := "0.1"

scalaVersion := "2.13.6"

val akkaVersion = "2.6.16"
val akkaHttpVersion = "10.2.6"
val scalaLoggingVersion = "3.9.4"
val logbackVersion = "1.2.6"
val postgreSQLVersion = "42.2.24"
val slickVersion = "3.3.3"
val cryptoVersion = "2.0.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.scala-logging" %% "scala-logging" % scalaLoggingVersion,
  "ch.qos.logback" % "logback-classic" % logbackVersion,
  "org.postgresql" % "postgresql" % postgreSQLVersion,
  "com.typesafe.slick" %% "slick" % slickVersion,
  "com.typesafe.slick" %% "slick-hikaricp" % slickVersion,
  "com.evolutiongaming" %% "crypto" % cryptoVersion,
)