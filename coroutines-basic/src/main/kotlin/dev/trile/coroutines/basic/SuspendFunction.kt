package dev.trile.coroutines.basic

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

fun main() = runBlocking(
  CoroutineName("parent") +
    newSingleThreadContext("SingleThread") // Dispatcher SingleThread only use one thread
) {

  launch(CoroutineName("child")) {

    doSomeThingToWait(3000) // release thread in SingleThread for another function
  }

  doSomeThingToWait(1000) // use thread in SingleThread

}

suspend fun doSomeThingToWait(waitTime: Long) {
  println("Current context when START: $coroutineContext")

  delay(waitTime) // simulator processing

  println("Current context when END  : $coroutineContext")
}
