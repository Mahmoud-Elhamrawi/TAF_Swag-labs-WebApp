package Listener;

import DriverFactory.DriverFactory;
import Utilities.LogUtility;
import Utilities.Utility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.time.LocalDate;

public class IInovkedListener implements IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        LogUtility.info("beforeInvocation"+testResult.getName());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        LogUtility.info("afterInvocation"+testResult.getName());
        if(testResult.getStatus() == ITestResult.FAILURE)
        {
            LogUtility.error("fail..."+testResult.getName());
            try {
                Utility.takeScreenShot(DriverFactory.getDriver() ,testResult.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
