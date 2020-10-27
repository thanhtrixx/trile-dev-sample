package dev.trile.customexception;

import static dev.trile.customexception.ErrorType.TRANSFER_MONEY_NOT_ENOUGH_MONEY;

public class VietcomBank implements Bank {

  @Override
  public void transferMoney(String accountNo, int amount) throws SalaryException {
    checkTransferParams(accountNo, amount);

    if (amount > 10_000_000)
      throw new SalaryException(TRANSFER_MONEY_NOT_ENOUGH_MONEY, "VCB only support transfer amount less than 10M");

    System.out.println("VCB transfer success");
  }
}
