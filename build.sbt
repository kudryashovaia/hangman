name := "hangman"

version := "0.1"

//scalaVersion := "2.13.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream-kafka" % "1.0.3",
  "com.iheart" %% "ficus" % "1.4.0",
  "org.scalatest" %% "scalatest" % "3.0.5"
)
