package dev.trile.iocdi

class VietinBank : Bank {

  override fun transferMoney(accountNo: String, amount: Int) {
    checkTransferParams(accountNo, amount)
    println("VTB transfer success")
  }
}
