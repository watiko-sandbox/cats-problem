package example

import cats.data.NonEmptyChain

sealed trait MyValidation
object MyValidation {
  case object ResultA extends MyValidation
  case object ResultB extends MyValidation
}

object ValidationEx {
  def main(args: Array[String]): Unit = {
    val v = new MyValidator
    println(v.validateMany())
  }
}

class MyValidator {
  import cats.implicits._

  type Result[A] = Either[NonEmptyChain[MyValidation], A]

  def validate1(): Result[Unit] = ().rightNec
  def validate2(): Result[Unit] = ().rightNec

  def validateMany(): Result[Unit] = (validate1(), validate2()).parTupled.map(_ => ())
}
