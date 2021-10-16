package com.catsy

import cats.effect.IO
import org.joda.time.DateTime

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.FiniteDuration

class Timing {

  val clock: MyIO[Long] = MyIO(() => System.currentTimeMillis())

  def time[A](action: MyIO[A]): MyIO[(FiniteDuration, A)] = for {
    start <- clock
    res <- action
    end <- clock
    duration = FiniteDuration(end - start, TimeUnit.MILLISECONDS)
  } yield (duration, res)

  def tickingClock: IO[Unit] = for {
    _ <- IO.println(DateTime.now())
    _ <- IO.sleep(FiniteDuration(1, TimeUnit.SECONDS))
    _ <- tickingClock
  } yield ()

}
