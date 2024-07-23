package Listener;

import Utilities.LogUtility;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class ITestResult implements ITestListener {
    public void onTestStart(org.testng.ITestResult result) {
        LogUtility.info("start execute tc");
    }

    public void onTestSuccess(org.testng.ITestResult result) {
        LogUtility.info("tc pass...");
    }

    public void onTestFailure(org.testng.ITestResult result) {
        LogUtility.error("tc fail...");
    }

    public void onTestSkipped(org.testng.ITestResult result) {
        LogUtility.warn("tc skipped...");
    }
    public void onStart(ITestContext context) {
        LogUtility.info("Test execute....");
    }

    public void onFinish(ITestContext context) {
        LogUtility.info("Test finished.....");
    }
}


