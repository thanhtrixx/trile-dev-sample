package dev.trile.coroutines.basic

import kotlinx.coroutines.*
import kotlin.random.Random

fun main() = runBlocking {

  launch { // context of the parent, main runBlocking coroutine
    println("main runBlocking            : I'm working in thread ${Thread.currentThread().name}")
  }
  launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
    println("Unconfined                 : I'm working in thread ${Thread.currentThread().name}")
  }
  launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
    println("Default                    : I'm working in thread ${Thread.currentThread().name}")
  }

  launch(newCoroutineContext(Dispatchers.Default)) { // will get its own new thread
    println("newCoroutineContext         : I'm working in thread ${Thread.currentThread().name}")
  }

  //
  val dispatcherWithTwoThread = newFixedThreadPoolContext(2, "ThreadPoll")

  repeat(10) {
    launch(dispatcherWithTwoThread) { // will get its own new thread
      println("dispatcherWithTwoThread${it.padEnd(3)}  : I'm working in thread ${Thread.currentThread().name}")
      delay(Random.nextLong(500, 5000))
      println("dispatcherWithTwoThread${it.padEnd(3)}  : I'm done in thread ${Thread.currentThread().name}")
    }
  }
}

fun Int.padEnd(length: Int, padChar: Char = '0') = this.toString().padStart(length, padChar)
