package Tests;

import Listener.IInovkedListener;
import Listener.ITestResult;
import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Pages.P03_cartPage;
import Utilities.DataUtility;
import Utilities.LogUtility;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;
@Listeners({IInovkedListener.class , ITestResult.class})
public class TC03_CartPage extends TestBase{


    @Test
    public void comparePricesOnHomePageWithCartPage()
    {
      String priceOnHomePage =    new P02_HomePage(getDriver()).addRandomProductsToCart(2,6)
                .totalPriceOfSelectedItem() ;
        LogUtility.info("total price home page :"+priceOnHomePage);
      new P02_HomePage(getDriver()).navigateToCartPage();

        Assert.assertTrue(new P03_cartPage(getDriver()).comparePriceOfHomePageWithPriceOfCartPage(priceOnHomePage));



    }



}
