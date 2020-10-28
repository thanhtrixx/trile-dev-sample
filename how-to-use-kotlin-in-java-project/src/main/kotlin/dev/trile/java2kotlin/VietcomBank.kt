package dev.trile.java2kotlin

import dev.trile.customexception.Bank
import dev.trile.customexception.ErrorType
import dev.trile.customexception.SalaryException

class VietcomBank : Bank {

  @Throws(SalaryException::class)
  override fun transferMoney(accountNo: String, amount: Int) {
    checkTransferParams(accountNo, amount)

    if (amount > 10000000)
      throw SalaryException(ErrorType.TRANSFER_MONEY_NOT_ENOUGH_MONEY, "VCB only support transfer amount less than 10M")

    println("VCB Kotlin transfer success")
  }
}
