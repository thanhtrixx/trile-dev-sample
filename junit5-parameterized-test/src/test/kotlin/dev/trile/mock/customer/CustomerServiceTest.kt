package dev.trile.mock.customer

import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


internal class CustomerServiceTest {

  private val customerRepository: CustomerRepository = mockk()
  private val customerService = CustomerService(customerRepository)

  @AfterEach
  fun tearDown() {
    clearMocks(customerRepository)
  }

  companion object {
    @JvmStatic
    fun provideToTestData() =
      Stream.of(
        Arguments.of(
          "Empty list",
          emptyList<String>(),
          emptyList<Customer>()
        ),

        Arguments.of(
          "One customer",
          listOf("Tri Le"),
          listOf(
            Customer(firstName = "Tri", lastName = "Le")
          )
        ),

        Arguments.of(
          "Two customers",
          listOf("Tri Le", "Anna Wesley"),
          listOf(
            Customer(firstName = "Tri", lastName = "Le"),
            Customer(firstName = "Anna", lastName = "Wesley"),
          )
        )
      )
  }

  @ParameterizedTest(name = "#{0} - {1} -> {2}")
  @MethodSource("provideToTestData")
  fun `test getFullNameCustomerWithTotalBuyPriceGreaterThan`(
    description: String,
    expected: List<String>,
    mockReturn: List<Customer>
  ) {
    val totalBuyPrice = 3_000

    every {
      customerRepository.findByTotalBuyPriceGreaterThan(3_000)
    } returns mockReturn

    assertEquals(
      expected,
      customerService.getFullNameCustomerWithTotalBuyPriceGreaterThan(3_000)
    )

    verify(exactly = 1) { customerRepository.findByTotalBuyPriceGreaterThan(totalBuyPrice) }

  }
}
