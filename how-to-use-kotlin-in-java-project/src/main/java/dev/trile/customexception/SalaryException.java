package dev.trile.customexception;

public class SalaryException extends Exception {

  private ErrorType codeType;

  public SalaryException(ErrorType errorType, String message) {
    super(message);
    this.codeType = errorType;
  }

  public ErrorType getCodeType() {
    return codeType;
  }
}

