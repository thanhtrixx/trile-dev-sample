package dev.trile.iocdi

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SalaryTransfer(
  private val moneyTransfer: MoneyTransfer,
  private val salaryCalculator: SalaryCalculator
) : CommandLineRunner {


  fun salaryTransfer(workingDay: Int, salaryPerDay: Int, accountNo: String?) {
    val salary = salaryCalculator.calcSalary(workingDay, salaryPerDay)
    moneyTransfer.transferMoney(accountNo!!, salary)
    println("Transfer Salary success")
  }

  override fun run(vararg args: String) {

    try {
      salaryTransfer(args[0].toInt(), args[1].toInt(), args[2])
    } catch (e: NumberFormatException) {
      println("Parse int error " + e.message)
    } catch (e: SalaryException) {
      println(e.message)
    }
  }

}

