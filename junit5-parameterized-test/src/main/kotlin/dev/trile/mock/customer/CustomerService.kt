package dev.trile.mock.customer

import org.springframework.stereotype.Component

@Component
class CustomerService(
  private val customerRepository: CustomerRepository
) {

  fun getFullNameCustomerWithTotalBuyPriceGreaterThan(totalBuyPrice: Int) =
    customerRepository
      .findByTotalBuyPriceGreaterThan(totalBuyPrice)
      .map { "${it.firstName} ${it.lastName}" }

}
