name := "com.jpm.test.Jpmo"

version := "0.1"

scalaVersion := "2.11.11"

libraryDependencies++= {
  val sparkVersion="2.2.0"
  Seq(
    "com.typesafe" % "config" % "1.3.3",
    "org.scalatest" %% "scalatest" % "3.0.5" % Test
  )
}