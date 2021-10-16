package com.catsy

import munit.FunSuite

class MyIOSuite extends FunSuite {

  test("should say hello catsy") {

    val hello = MyIO.putStr("hello")
    val catsy = MyIO.putStr("catsy")

    val helloCatsy: MyIO[Unit] = for {
      _ <- hello
      _ <- catsy
    } yield ()

    assertEquals(helloCatsy.unsafeRun(), ())

  }

}
