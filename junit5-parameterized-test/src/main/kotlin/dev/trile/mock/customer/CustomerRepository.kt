package dev.trile.mock.customer

import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long> {

  fun findByTotalBuyPriceGreaterThan(totalBuyPrice: Int): List<Customer>

}
