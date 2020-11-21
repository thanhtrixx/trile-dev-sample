package dev.trile.coroutines.basic

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

  val timeNotCancel = measureTimeMillis {
    val job = launch {
      delay(3_000) // done after 3000 ms
    }

    delay(1_000)
    job.join() // wait job done
  }

  println("Time to run not cancel $timeNotCancel ms")

  val timeWithCancel = measureTimeMillis {
    val job = launch {
      delay(3_000) // done after 3000 ms
    }

    delay(1_000)

    job.cancel() // not wait delay(3_000)
    job.join() // wait job done
  }

  println("Time to run with cancel $timeWithCancel ms")

}
