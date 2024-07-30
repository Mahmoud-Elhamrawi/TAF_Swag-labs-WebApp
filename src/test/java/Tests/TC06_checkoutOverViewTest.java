package Tests;

import Pages.*;
import Utilities.DataUtility;
import Utilities.LogUtility;
import Utilities.Utility;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC06_checkoutOverViewTest extends  TestBase{
    final  String  FIRSTNAME = DataUtility.readJsonFile("checkoutInfo","fName")+"_"+ Utility.timeStemp();
    final  String  LASTNAME = DataUtility.readJsonFile("checkoutInfo","lName")+"_"+ Utility.timeStemp();
    final  String  ZIPCODE = new Faker().number().digits(6);

    @Test
    public void checkoutStepTwo()
    {
        //TODO::login
        new P01_LoginPage(getDriver())
                .enterUserName(DataUtility.readJsonFile("userlogin","name"))
                .enterUserPassword(DataUtility.readJsonFile("userlogin","password"))
                .clickLoginBtn() ;
        //TODO::add products to cart
        new P02_HomePage(getDriver())
                .addProductsToCart()
                .navigateToCartPage();
        //TODO::navigate to checkout
        new P03_cartPage(getDriver())
                .naviagteTOCheckOut();
        //TODO::filling data
        new P04_checkoutPage(getDriver())
                .fillInfoData(FIRSTNAME,LASTNAME,ZIPCODE)
                .clickOnContinueBtn();

        LogUtility.info(FIRSTNAME+LASTNAME+ZIPCODE);
        Assert.assertTrue(new P06_CheckoutOverViewPage(getDriver()).compareTotalPriceWithGetTotal());

    }





}
