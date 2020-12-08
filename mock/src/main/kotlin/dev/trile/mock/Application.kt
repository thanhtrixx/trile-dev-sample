package dev.trile.mock

import dev.trile.mock.customer.CustomerService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application(
  private val customerService: CustomerService
) : CommandLineRunner {

  override fun run(vararg args: String) {
    val totalBuyPrice =
      if (args.isNotEmpty()) {
        args[0].toIntOrNull() ?: 30_000_000
      } else {
        30_000_000
      }

    println("Find all customer with total buy price greater than $totalBuyPrice")

    customerService
      .getFullNameCustomerWithTotalBuyPriceGreaterThan(totalBuyPrice)
      .forEach(::println)

    println("Done")

  }
}

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
