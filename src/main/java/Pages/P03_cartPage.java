package Pages;

import Utilities.LogUtility;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_cartPage {


    private final WebDriver driver;

    public P03_cartPage(WebDriver driver) {
        this.driver = driver ;
    }


    private final By priceOfSelectedProds = By.xpath("//button[.='Remove']//preceding-sibling::div[@class=\"inventory_item_price\"]");
    private final By checkoutBtn = By.id("checkout");
    List<WebElement> priceOfProds;


    static float totalPrice =0 ;

    private String totalPriceOfProdsFromCartPage()
    {
        try {
            priceOfProds  = driver.findElements(priceOfSelectedProds);
            for(int i=1 ;i<=priceOfProds.size();i++)
            {
                By priceOfSelectedProds = By.xpath("(//button[.='Remove']//preceding-sibling::div[@class=\"inventory_item_price\"])["+i+"]");
               String fullPrice = Utility.getTextEle(driver , priceOfSelectedProds);
               totalPrice +=Float.parseFloat(fullPrice.replace("$",""));
            }
            LogUtility.info("total price on cart page :"+totalPrice);
            return String.valueOf(totalPrice);
        }catch (Exception e)
        {
            LogUtility.error(e.getMessage());

        }
        return "0";
    }

    public boolean comparePriceOfHomePageWithPriceOfCartPage(String price)
    {
        return totalPriceOfProdsFromCartPage().equals(price);
    }


    public P04_checkoutPage naviagteTOCheckOut()
    {
        Utility.clickEle(driver , checkoutBtn);
        return new P04_checkoutPage(driver);
    }









}
