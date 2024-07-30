package Tests;

import Pages.*;
import Utilities.DataUtility;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC07_finishingOrderTest extends TestBase{


    final String FIRSTNAME = DataUtility.readJsonFile("checkoutInfo","fName");
    final String LASTNAME = DataUtility.readJsonFile("checkoutInfo","lName");
    final String ZIPCODE = new Faker().number().digits(6);

    @Test
    public void completeOrder()
    {
      //TODO::login
        new P01_LoginPage(getDriver())
                .enterUserName(DataUtility.readJsonFile("userlogin","name"))
                .enterUserPassword(DataUtility.readJsonFile("userlogin","password"))
                .clickLoginBtn();
        //TODO::add products to cart
        new P02_HomePage(getDriver())
                .addProductsToCart()
                .navigateToCartPage();
        //TODO::navigate to checkout page
        new P03_cartPage(getDriver())
                .naviagteTOCheckOut();
        //TODO::filling data
        new P04_checkoutPage(getDriver())
                .fillInfoData(FIRSTNAME,LASTNAME,ZIPCODE)
                .clickOnContinueBtn();
        

        //TODO::finishing order
        new P06_CheckoutOverViewPage(getDriver())
                .navigateToFinishOrder();
        Assert.assertTrue(new P07_finishOrder(getDriver()).checkVisibilityOfMSG());







    }


}
