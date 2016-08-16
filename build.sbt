name := "advertservice"

version := "0.1"

scalaVersion := "2.11.8"

organization := "com.nextperience"

resolvers += Resolver.bintrayRepo("hseeberger", "maven")

val circeV = "0.4.1"
val Json4sVersion     = "3.2.11"

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-http-experimental_2.11" % "2.4.9-RC2",
  "com.typesafe.akka" %% "akka-http-testkit" % "2.4.9-RC1",
  "org.scalatest" % "scalatest_2.11" % "3.0.0",
  "de.heikoseeberger" %% "akka-http-json4s" % "1.8.0",
  "org.json4s" %% "json4s-jackson" % "3.2.11",
  "org.json4s" % "json4s-ext_2.11" % "3.4.0"
)
