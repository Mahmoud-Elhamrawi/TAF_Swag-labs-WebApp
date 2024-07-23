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

}


