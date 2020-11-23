package dev.trile.iocdi

import org.springframework.stereotype.Component

@Component
class MoneyTransfer(
  private val primaryBank: Bank,
  private val secondaryBank: Bank
) {

  fun transferMoney(accountNo: String, amount: Int) {
    println("Transfer $amount to $accountNo")
    try {
      primaryBank.transferMoney(accountNo, amount)
    } catch (e: SalaryException) {
      println(e.message)
      if (e.codeType !== ErrorType.TRANSFER_MONEY_NOT_ENOUGH_MONEY) throw e // rethrow exception
      println("Retry with VTB")
      // try with VietinBank
      secondaryBank.transferMoney(accountNo, amount)
    }
  }
}
