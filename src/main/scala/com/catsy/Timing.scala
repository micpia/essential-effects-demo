package com.catsy

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

}
