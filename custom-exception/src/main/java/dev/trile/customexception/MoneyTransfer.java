package dev.trile.customexception;

import static dev.trile.customexception.ErrorType.TRANSFER_MONEY_NOT_ENOUGH_MONEY;

public class MoneyTransfer {

  private final Bank vietcomBank = new VietcomBank();

  private final Bank vietinBank = new VietinBank();

  public void transferMoney(String accountNo, int amount) throws SalaryException {
    System.out.println("Transfer " + amount + " to " + accountNo);

    try {
      vietcomBank.transferMoney(accountNo, amount);
    } catch (SalaryException e) {
      System.out.println(e.getMessage());

      if (e.getCodeType() != TRANSFER_MONEY_NOT_ENOUGH_MONEY)
        throw e; // rethrow exception

      System.out.println("Retry with VTB");
      // try with VietinBank
      vietinBank.transferMoney(accountNo, amount);
    }
  }
}
