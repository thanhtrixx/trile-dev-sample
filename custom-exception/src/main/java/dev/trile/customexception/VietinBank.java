package dev.trile.customexception;

public class VietinBank implements Bank {

  @Override
  public void transferMoney(String accountNo, int amount) throws SalaryException {
    checkTransferParams(accountNo, amount);

    System.out.println("VTB transfer success");
  }
}
