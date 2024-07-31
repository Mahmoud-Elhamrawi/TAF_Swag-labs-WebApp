package Tests;

import Listener.IInovkedListener;
import Listener.ITestResult;
import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Utilities.DataUtility;
import Utilities.LogUtility;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.*;
@Listeners({IInovkedListener.class, ITestResult.class})
public class TC02_addToCartTest extends TestBase{





    @Test
    public void addProductsToCart()
    {

              new P02_HomePage(getDriver()).addProductsToCart() ;

        Assert.assertTrue(new P02_HomePage(getDriver()).compareCountCartWithSelectedProd());



    }

    @Test
    public void addRandomProductsToCart()
    {

        new P02_HomePage(getDriver()).addRandomProductsToCart(2,6) ;


        Assert.assertTrue(new P02_HomePage(getDriver()).compareCountCartWithSelectedProd());
    }






    @Test
    public void navigateToCartPage()
    {

        new P02_HomePage(getDriver()).addRandomProductsToCart(2,6)
                .navigateToCartPage();
        LogUtility.info("cartPageUrl: "+DataUtility.readPropertyFile("env","cartPage"));

        Assert.assertTrue(new P02_HomePage(getDriver()).verifyOnCartPage(DataUtility.readPropertyFile("env","cartPage")));
    }


}
