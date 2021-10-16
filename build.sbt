ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.13.5"

hydraIsEnabled := false

lazy val root = (project in file(".")).settings(
  name := "essential-effect-demo",
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "3.2.9",
    "org.typelevel" %% "cats-effect-kernel" % "3.2.9",
    "org.typelevel" %% "cats-effect-std" % "3.2.9",
    compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
    "org.typelevel" %% "cats-effect-testing-specs2" % "1.3.0" % Test,
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.6" % Test
  )
)
