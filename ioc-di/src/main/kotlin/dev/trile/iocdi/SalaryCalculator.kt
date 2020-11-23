package dev.trile.iocdi

import org.springframework.stereotype.Component

@Component
class SalaryCalculator {

  fun calcSalary(workingDay: Int, salaryPerDay: Int): Int {
    if (workingDay <= 0) throw SalaryException(ErrorType.CALC_SALARY_PARAMS_INVALID, "WorkingDay less than or equal zero")
    if (salaryPerDay <= 0) throw SalaryException(ErrorType.CALC_SALARY_PARAMS_INVALID, "SalaryPerDay less than or equal zero")
    return workingDay * salaryPerDay
  }
}
