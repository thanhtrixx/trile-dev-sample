/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dev.trile.customexception;

import org.testng.annotations.Test;

public class SalaryTransferTest {

    @Test
    public void testSalaryTransfer() throws SalaryException {
        SalaryTransfer salaryTransfer = new SalaryTransfer();

        salaryTransfer.salaryTransfer(1, 100_000, "EM1");
    }
}
