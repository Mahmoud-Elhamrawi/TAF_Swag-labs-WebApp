package Listener;

import DriverFactory.DriverFactory.*;
import Pages.P02_HomePage;
import Utilities.LogUtility;
import Utilities.Utility;
import io.qameta.allure.Allure;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static DriverFactory.DriverFactory.getDriver;
import static Utilities.Utility.takeScreenShot;


public class IInovkedListener implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        LogUtility.info("beforeInvocation : "+testResult.getName());

    }



    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        File logfiles = Utility.getLatestFile(LogUtility.log_path);
        try {
            assert logfiles != null;
            Allure.addAttachment("logs.log", Files.readString(Path.of(logfiles.getPath())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (testResult.getStatus() == ITestResult.FAILURE) {
            LogUtility.error("fail..." + testResult.getName());
            try {
                takeScreenShot(getDriver(), testResult.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //Utility.takeFullScreenShot(getDriver(),new P02_HomePage(getDriver()).iconCartEle());
        }
    }

}
