package cn.automation.MySelenium.AutomationTestCommon.test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Set;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

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
        Set<ITestResult> skippedTests = iTestContext.getSkippedTests().getAllResults();

        for (ITestResult temp : skippedTests) {
            skippedTests.remove(temp);
        }
    }
}
