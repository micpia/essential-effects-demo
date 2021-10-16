package com.catsy

import munit.FunSuite

class TimingSuite extends FunSuite {

  test("should time operation") {

    val timing = new Timing

    val timedHello = timing.time(MyIO.putStr("hello"))

    timedHello.unsafeRun() match {
      case (duration, _) => println(s"hello took: $duration")
    }

    assertEquals(1, 1)

  }

}
