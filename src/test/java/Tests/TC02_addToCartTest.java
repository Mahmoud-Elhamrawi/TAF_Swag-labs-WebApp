package Tests;

import Listener.IInovkedListener;
import Listener.ITestResult;
import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Utilities.DataUtility;
import Utilities.LogUtility;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.*;
@Listeners({IInovkedListener.class, ITestResult.class})
public class TC02_addToCartTest extends TestBase{




    @Description("add All products to cart :")
    @Severity(SeverityLevel.MINOR)
    @Owner("elhamrawi")
    @Epic("Web App")
    @Feature("add prods to cart ")
    @Story("valid use case")
    @Test
    public void addProductsToCart()
    {

              new P02_HomePage(getDriver()).addProductsToCart() ;

        Assert.assertTrue(new P02_HomePage(getDriver()).compareCountCartWithSelectedProd());



    }
    @Description("add Random products to cart :")
    @Severity(SeverityLevel.MINOR)
    @Owner("elhamrawi")
    @Epic("Web App")
    @Feature("add prods to cart ")
    @Story("valid use case")
    @Test
    public void addRandomProductsToCart()
    {

        new P02_HomePage(getDriver()).addRandomProductsToCart(2,6) ;


        Assert.assertTrue(new P02_HomePage(getDriver()).compareCountCartWithSelectedProd());
    }




    @Description("navigate To Cart Page :")
    @Severity(SeverityLevel.MINOR)
    @Owner("elhamrawi")
    @Epic("Web App")
    @Feature("navigate To Cart Page ")
    @Story("valid use case")
    @Test
    public void navigateToCartPage()
    {

        new P02_HomePage(getDriver()).addRandomProductsToCart(2,6)
                .navigateToCartPage();
        LogUtility.info("cartPageUrl: "+DataUtility.readPropertyFile("env","cartPage"));

        Assert.assertTrue(new P02_HomePage(getDriver()).verifyOnCartPage(DataUtility.readPropertyFile("env","cartPage")));
    }


}
