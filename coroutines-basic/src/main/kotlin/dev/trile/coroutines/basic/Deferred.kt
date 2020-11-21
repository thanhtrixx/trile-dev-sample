package dev.trile.coroutines.basic

import kotlinx.coroutines.*
import kotlin.random.Random

fun main() = runBlocking {

  println("--------- async ---------")

  val deferred = async { getRandomInt() }

  println("Wait async-getRandomInt result")

  println("RandomInt from async-getRandomInt = ${deferred.await()}")

  println("------ CompletableDeferred ------")

  val completableDeferred = CompletableDeferred<Int>()

  launch {
    delay(1000)

    val result = Random.nextInt(1, 10)

    println("completableDeferred done with result $result")

    completableDeferred.complete(result)
  }

  println("Wait completableDeferred result")
  println("RandomInt from completableDeferred = ${completableDeferred.await()}")

}

suspend fun getRandomInt(): Int {
  delay(1000)

  val result = Random.nextInt(1, 10)

  println("async-getRandomInt done with result $result")

  return result
}
