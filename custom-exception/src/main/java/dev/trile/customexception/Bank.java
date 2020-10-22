package dev.trile.customexception;

import static dev.trile.customexception.ErrorType.TRANSFER_MONEY_PARAMS_INVALID;

public interface Bank {

  void transferMoney(String accountNo, int amount) throws SalaryException;

  default void checkTransferParams(String accountNo, int amount) throws SalaryException {

    if (accountNo == null || accountNo.length() == 0)
      throw new SalaryException(TRANSFER_MONEY_PARAMS_INVALID, "AccountNo null or empty");

    if (amount <= 0)
      throw new SalaryException(TRANSFER_MONEY_PARAMS_INVALID, "Amount less than 0");
  }
}
