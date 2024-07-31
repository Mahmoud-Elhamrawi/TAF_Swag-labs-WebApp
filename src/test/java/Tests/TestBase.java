package Tests;

import Pages.P01_LoginPage;
import Utilities.DataUtility;
import Utilities.LogUtility;
import Utilities.Utility;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Set;

import static DriverFactory.DriverFactory.*;

public class TestBase {

    private Set<Cookie> cookies ;
    @BeforeClass
    public void loginSteps()
    {
        setup(DataUtility.readPropertyFile("env","Browser"));
        LogUtility.info("open browser");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(DataUtility.readPropertyFile("env","URL"));
        LogUtility.info("redirect to base url");

        new P01_LoginPage(getDriver())
                .enterUserName(DataUtility.readJsonFile("userlogin","name"))
                .enterUserPassword(DataUtility.readJsonFile("userlogin","password"))
                .clickLoginBtn();
        cookies = Utility.getAllCookies(getDriver());
        getDriver().quit();

    }





    @BeforeMethod
    public void starting()
    {
        setup(DataUtility.readPropertyFile("env","Browser"));
        LogUtility.info("open browser");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(DataUtility.readPropertyFile("env","URL"));
        LogUtility.info("redirect to base url");
        Utility.restoreCookies(getDriver(),cookies);
        getDriver().get(DataUtility.readPropertyFile("env","homepage"));

        getDriver().navigate().refresh();

    }


    @AfterMethod
    public void tearDown()
    {
        getDriver().quit();
        threadLocal.remove();
    }

    @AfterClass
        public void deleteCookie()
    {
        cookies.clear();
    }



}
