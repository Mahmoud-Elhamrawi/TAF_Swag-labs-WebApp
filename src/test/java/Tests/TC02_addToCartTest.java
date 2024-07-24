package Tests;

import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Utilities.DataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.*;

public class TC02_addToCartTest extends TestBase{





    @Test
    public void addProductsToCart()
    {
       new P01_LoginPage(getDriver())
               .enterUserName(DataUtility.readJsonFile("userlogin","name"))
               .enterUserPassword(DataUtility.readJsonFile("userlogin","password"))
               .clickLoginBtn()
               .addProductsToCart() ;

        Assert.assertTrue(new P02_HomePage(getDriver()).compareCountCartWithSelectedProd());



    }


}
