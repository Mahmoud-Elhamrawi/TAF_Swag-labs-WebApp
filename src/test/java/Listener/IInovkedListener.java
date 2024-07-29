package Listener;

import DriverFactory.DriverFactory.*;
import Pages.P02_HomePage;
import Utilities.LogUtility;
import Utilities.Utility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import static DriverFactory.DriverFactory.getDriver;


public class IInovkedListener implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        LogUtility.info("beforeInvocation : "+testResult.getName());

    }



    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        LogUtility.info("afterInvocation : "+testResult.getName());
        if(testResult.getStatus() == ITestResult.FAILURE)
        {

            try {
                LogUtility.error("fail..."+testResult.getName());
                Utility.takeScreenShot(getDriver() ,testResult.getName());
                Utility.takeFullScreenShot(getDriver(),new P02_HomePage(getDriver()).iconCartEle());
            } catch (Exception e) {

                LogUtility.error(e.getMessage());
            }
        }
    }


}
