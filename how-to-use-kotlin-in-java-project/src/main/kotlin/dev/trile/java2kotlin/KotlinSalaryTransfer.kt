package dev.trile.java2kotlin

import dev.trile.customexception.MoneyTransfer
import dev.trile.customexception.SalaryCalculator
import dev.trile.customexception.SalaryException
import dev.trile.customexception.SalaryTransfer

class KotlinSalaryTransfer {
  private val moneyTransfer = MoneyTransfer()
  private val salaryCalculator = SalaryCalculator()

  fun salaryTransfer(workingDay: Int, salaryPerDay: Int, accountNo: String?) {
    val salary = salaryCalculator.calcSalary(workingDay, salaryPerDay)
    moneyTransfer.transferMoney(accountNo, salary)
    println("Transfer Salary success")
  }
}

fun main(args: Array<String>) {
  val salaryTransfer = SalaryTransfer()
  try {
    salaryTransfer.salaryTransfer(args[0].toInt(), args[1].toInt(), args[2])
  } catch (e: NumberFormatException) {
    println("Parse int error " + e.message)
  } catch (e: SalaryException) {
    println(e.message)
  }
}
