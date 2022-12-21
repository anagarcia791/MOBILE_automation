package util.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.reporter.Reporter;

/**
 * Listener class for give information about test result,
 * this class implements ITestListener.
 *
 * @author am.garcia
 */
public class Listener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.info("Test: " + result.getName() + " [PASSED]");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.error("Test: " + result.getName() + " [FAILED]");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}