package dev.trile.iocdi

interface Bank {

  fun transferMoney(accountNo: String, amount: Int)

  fun checkTransferParams(accountNo: String, amount: Int) {
    if (accountNo.length == 0) throw SalaryException(ErrorType.TRANSFER_MONEY_PARAMS_INVALID, "AccountNo empty")
    if (amount <= 0) throw SalaryException(ErrorType.TRANSFER_MONEY_PARAMS_INVALID, "Amount less than or equal zero")
  }
}
