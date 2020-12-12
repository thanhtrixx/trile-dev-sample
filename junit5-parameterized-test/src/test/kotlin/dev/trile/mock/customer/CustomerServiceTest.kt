package dev.trile.mock.customer

import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


internal class CustomerServiceTest {

  private val customerRepository: CustomerRepository = mockk()
  private val customerService = CustomerService(customerRepository)

  @AfterEach
  fun tearDown() {
    clearMocks(customerRepository)
  }

  @Test
  fun `test getFullNameCustomerWithTotalBuyPriceGreaterThan return empty`() {
    val totalBuyPrice = 3_000

    every {
      customerRepository.findByTotalBuyPriceGreaterThan(totalBuyPrice)
    } returns emptyList()

    assertTrue(
      customerService.getFullNameCustomerWithTotalBuyPriceGreaterThan(totalBuyPrice).isEmpty()
    )

    verify(exactly = 1) { customerRepository.findByTotalBuyPriceGreaterThan(totalBuyPrice) }
  }

  @Test
  fun `test getFullNameCustomerWithTotalBuyPriceGreaterThan return one customer`() {
    val totalBuyPrice = 3_000

    every {
      customerRepository.findByTotalBuyPriceGreaterThan(3_000)
    } returns listOf(
      Customer(firstName = "Tri", lastName = "Le")
    )

    assertEquals(
      listOf("Tri Le"),
      customerService.getFullNameCustomerWithTotalBuyPriceGreaterThan(3_000)
    )

    verify(exactly = 1) { customerRepository.findByTotalBuyPriceGreaterThan(totalBuyPrice) }

  }

  @Test
  fun `test getFullNameCustomerWithTotalBuyPriceGreaterThan return two customer`() {
    val totalBuyPrice = 3_000

    every {
      customerRepository.findByTotalBuyPriceGreaterThan(3_000)
    } returns listOf(
      Customer(firstName = "Tri", lastName = "Le"),
      Customer(firstName = "Anna", lastName = "Wesley"),
    )

    assertEquals(
      listOf("Tri Le", "Anna Wesley"),
      customerService.getFullNameCustomerWithTotalBuyPriceGreaterThan(3_000)
    )

    verify(exactly = 1) { customerRepository.findByTotalBuyPriceGreaterThan(totalBuyPrice) }

  }
}
