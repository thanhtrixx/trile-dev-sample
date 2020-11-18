package dev.trile.coroutinesbasic

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.ContinuationInterceptor

fun main() = runBlocking<Unit> {

  println("Current context is: $coroutineContext")

  println("New context with name: ${coroutineContext + CoroutineName("test")}")

  println("Job in current context is: ${coroutineContext[Job]}")

  println("Dispatcher in current context is: ${coroutineContext[ContinuationInterceptor]}")

  launch(CoroutineName("child")) {
    println("Child context is $coroutineContext}")

    println("CoroutineName in current context is: ${coroutineContext[CoroutineName]}")
  }

}
