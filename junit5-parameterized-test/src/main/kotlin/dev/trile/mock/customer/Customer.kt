package dev.trile.mock.customer

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customer")
data class Customer(

  @Id
  @GeneratedValue
  val id: Long = 0,

  val firstName: String = "",
  val lastName: String = "",

  val totalBuyPrice: Int = 0
)
