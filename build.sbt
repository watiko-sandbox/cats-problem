name := "tools"

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version := "0.1.0-SNAPSHOT"

val commonOptions = Seq(
  "-encoding",
  "UTF-8",                 // source files are in UTF-8
  "-deprecation",          // warn about use of deprecated APIs
  "-unchecked",            // warn about unchecked type parameters
  "-feature",              // warn about misused language features
  "-language:higherKinds", // allow higher kinded types without `import scala.language.higherKinds`
  "-Xlint",                // enable handy linter warnings
  "-Xfatal-warnings",      // turn compiler warnings into errors
  "-Ypartial-unification", // allow the compiler to unify type constructors of different arities
  "-Ywarn-unused:-imports,_"
)

lazy val commonLibraries = Seq("org.typelevel" %% "cats-core" % "1.6.0")

lazy val root = (project in file("."))
  .settings(
    name := "root",
    libraryDependencies ++= commonLibraries,
    scalacOptions ++= commonOptions
  )

lazy val sub = (project in file("sub"))
  .settings(
    name := "sub",
    libraryDependencies ++= commonLibraries,
    scalacOptions ++= commonOptions
  )
