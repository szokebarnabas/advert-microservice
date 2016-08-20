name := "advertservice"

version := "0.1"

scalaVersion := "2.11.8"

organization := "com.nextperience"

resolvers += Resolver.bintrayRepo("hseeberger", "maven")
resolvers += "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/"

val Json4sVersion     = "3.2.11"
val AkkaVersion       = "2.4.9-RC2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-http-experimental_2.11" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % "2.4.9-RC1",
  "com.typesafe.akka" %% "akka-slf4j"      % AkkaVersion,
  "org.scalatest" % "scalatest_2.11" % "3.0.0",
  "de.heikoseeberger" %% "akka-http-json4s" % "1.8.0",
  "org.json4s" %% "json4s-jackson" % "3.2.11",
  "org.json4s" % "json4s-ext_2.11" % "3.4.0",
  "org.reactivemongo" %% "reactivemongo" % "0.11.14",
  "org.json4s" % "json4s-mongo_2.11" % "3.4.0"

)

mainClass in Global := Some("com.nextperience.jp.advert.Main")