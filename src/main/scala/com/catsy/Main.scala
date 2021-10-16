package com.catsy

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = IO.pure(ExitCode.Success)

}
