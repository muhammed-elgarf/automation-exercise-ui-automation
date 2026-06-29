package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestExecutionListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        result.setAttribute("startTime", System.currentTimeMillis());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        printExecutionTime(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        printExecutionTime(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        printExecutionTime(result);
    }

    private void printExecutionTime(ITestResult result) {

        long start =
                (Long) result.getAttribute("startTime");

        long duration =
                System.currentTimeMillis() - start;

        System.out.println("\n======================================");
        System.out.println("Test Class : "
                + result.getTestClass().getName());

        System.out.println("Test Method: "
                + result.getMethod().getMethodName());

        System.out.println("Execution Time: "
                + duration + " ms");

        System.out.println("======================================");
    }
}