package Tests;

import Utilities.DataUtility;
import Utilities.LogUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static DriverFactory.DriverFactory.*;

public class TestBase {

    @BeforeMethod
    public void starting()
    {
        setup(DataUtility.readPropertyFile("env","Browser"));
        LogUtility.info("open browser");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(DataUtility.readPropertyFile("env","URL"));
        LogUtility.info("redirect to base url");

    }


    @AfterMethod
    public void tearDown()
    {
        getDriver().quit();
        threadLocal.remove();
    }





}
