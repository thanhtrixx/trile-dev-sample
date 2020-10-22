package dev.trile.customexception;

public class SalaryTransfer {

  private final MoneyTransfer moneyTransfer = new MoneyTransfer();
  private final SalaryCalculator salaryCalculator = new SalaryCalculator();

  public void salaryTransfer(int workingDay, int salaryPerDay, String accountNo) throws SalaryException {

    int salary = salaryCalculator.calcSalary(workingDay, salaryPerDay);
    moneyTransfer.transferMoney(accountNo, salary);
    System.out.println("Transfer Salary success");

  }

  public static void main(String[] args) {
    SalaryTransfer salaryTransfer = new SalaryTransfer();

    try {
      salaryTransfer.salaryTransfer(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
    } catch (NumberFormatException e) {
      System.out.println("Parse int error " + e.getMessage());
    } catch (SalaryException e) {
      System.out.println(e.getMessage());
    }
  }
}
