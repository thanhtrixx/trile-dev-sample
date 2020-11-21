package dev.trile.coroutines.basic

import kotlinx.coroutines.*

fun main() = runBlocking {

  val job = launch(CoroutineName("parent")) { // parent scope
    println("Start $coroutineContext")

    async(CoroutineName("child-1")) {
      println("Start $coroutineContext")
      delay(1000)
      println("End $coroutineContext")
    }

    async(CoroutineName("child-2")) {
      println("Start $coroutineContext")
      delay(3000)
      println("End $coroutineContext") // not execute this line
    }

    println("End $coroutineContext") // still wait child-1 and child-2 finish
  }

  delay(2000)
  job.cancel() // cancel but child-2 not finish

  println("Done")
}
