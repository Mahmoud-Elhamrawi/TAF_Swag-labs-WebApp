package Tests;


import Listener.IInovkedListener;
import Listener.ITestResult;
import Pages.P01_LoginPage;
import Utilities.DataUtility;
import Utilities.LogUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;
import static DriverFactory.DriverFactory.*;

@Listeners({ITestResult.class, IInovkedListener.class})
public class TC01_LoginTest extends TestBase {

    private final String userName = DataUtility.readJsonFile("userlogin","name");
    private final String userPassword = DataUtility.readJsonFile("userlogin","password");


    @Test
    public void validLoginTC()
    {
        new P01_LoginPage(getDriver())
                .enterUserName(userName)
                .enterUserPassword(userPassword)
                .clickLoginBtn();

        Assert.assertTrue(new P01_LoginPage(getDriver()).assertUrl(DataUtility.readPropertyFile("env","homepage")));

    }


}
