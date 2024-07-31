package Tests;

import Listener.IInovkedListener;
import Listener.ITestResult;
import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Pages.P04_checkoutPage;
import Utilities.DataUtility;
import Utilities.LogUtility;
import Utilities.Utility;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;
@Listeners({ITestResult.class , IInovkedListener.class})
public class TC04_checkoutTest  extends  TestBase{

    public static String FIRSTNAME = DataUtility.readJsonFile("checkoutInfo","fName")+"-"+ Utility.timeStemp();
    public static String LASTNAME = DataUtility.readJsonFile("checkoutInfo","lName") +"-"+ Utility.timeStemp();
    public static String ZIPCODE = new Faker().number().digits(6);


    @Test
    public void checkoutProcess()
    {
        //TODO::login
       // new P01_LoginPage(getDriver())
              //  .enterUserName(DataUtility.readJsonFile("userlogin","name"))
              //  .enterUserPassword(DataUtility.readJsonFile("userlogin","password"))
              //  .clickLoginBtn();

        //TODO::add products to cart
        new P02_HomePage(getDriver())
                .addRandomProductsToCart(2,6)
                .navigateToCartPage()
                .naviagteTOCheckOut();

        //TODO::fill info
        new P04_checkoutPage(getDriver())
                .fillInfoData(FIRSTNAME,LASTNAME,ZIPCODE)
                .clickOnContinueBtn() ;
        LogUtility.info(FIRSTNAME + LASTNAME + ZIPCODE);

        Assert.assertTrue(new P04_checkoutPage(getDriver()).verifyUrl(DataUtility.readPropertyFile("env","checkoutUrl")));


    }






}
