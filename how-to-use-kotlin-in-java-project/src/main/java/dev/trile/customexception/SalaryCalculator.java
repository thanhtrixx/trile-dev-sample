package dev.trile.customexception;

import static dev.trile.customexception.ErrorType.CALC_SALARY_PARAMS_INVALID;

public class SalaryCalculator {

  public int calcSalary(int workingDay, int salaryPerDay) throws SalaryException {

    if (workingDay <= 0)
      throw new SalaryException(CALC_SALARY_PARAMS_INVALID, "WorkingDay less than or equal zero");

    if (salaryPerDay <= 0)
      throw new SalaryException(CALC_SALARY_PARAMS_INVALID, "SalaryPerDay less than or equal zero");

    return workingDay * salaryPerDay;
  }
}
