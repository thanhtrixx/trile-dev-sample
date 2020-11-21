package dev.trile.coroutines.advanced

import kotlinx.coroutines.async
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread
import kotlin.system.measureNanoTime

fun main(args: Array<String>) = runBlocking {

  val max = 1000_000_000L // the max value which counter need increase to this

  // increase use one thread
  var counterSync = 0L
  val timeSync = measureNanoTime { counterSync = increaseSync(max) }
  println("increaseSync: counterSync                        [$counterSync] - time [$timeSync]")

  val workers = 5 // number workers to split into sub many increment

  var counterMapReduce = 0L
  val timeMapReduce = measureNanoTime { counterMapReduce = increaseMapReduce(max, workers) }
  println("increaseSync with Map-Reduce: counterMapReduce   [${counterMapReduce}] - time [$timeMapReduce]")

  var atomicCounter = AtomicLong()
  val timeAtomicCounter = measureNanoTime { increaseWithAtomic(max, workers, atomicCounter) }

  println("increaseWithAtomic: atomicCounter                [${atomicCounter.get()}] - time [$timeAtomicCounter]")

}

// just use for statement in one thread
fun increaseSync(max: Long): Long {
  var counter = 0L
  for (i in 0 until (max)) {
    counter++
  }
  return counter
}

// create workers group then increase couter in each worker and sum it
suspend fun increaseMapReduce(max: Long, workers: Int): Long = runBlocking {
  val maxByWorker = max / workers // max counter of each worker

  val threadPool = newFixedThreadPoolContext(workers, "workerThreadPool") // workers group

  (1..workers)
    .map { async(threadPool) { increaseSync(maxByWorker) } } // create worker jobs
    .map { it.await() } // wait all jobs of workers done
    .reduce { acc, current -> acc + current } // sum max counter of each worker
}

// create thread group and shared couter, each thread will increase shared couter and wait all threads done
fun increaseWithAtomic(max: Long, workers: Int, atomicCounter: AtomicLong) {
  val maxByWorker = max / workers

  val threads = (1..workers)
    .map {// create thread group
      thread {
        for (i in 0 until maxByWorker) {
          atomicCounter.incrementAndGet() // increase atomic opertation
        }
      }
    }

  for (thread in threads) { // wait all threads done
    thread.join()
  }
}
