package Pages;

import Utilities.LogUtility;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P02_HomePage {
    public final WebDriver driver;

    public P02_HomePage(WebDriver driver) {
        this.driver = driver ;
    }

    private final By addToCartBtns = By.xpath("//button[@class]");
    private final By iconCartCount = By.className("shopping_cart_badge");
    private final By selectedProducts = By.xpath("//button[.='Remove']") ;

    public static List<WebElement> allProducts ;
    public static List<WebElement> selectedProd ;

    public P02_HomePage addProductsToCart()
    {
        allProducts  =driver.findElements(addToCartBtns);
        LogUtility.info("products are add: "+allProducts.size());
        for(int i=1;i<=allProducts.size();i++)
        {

            By addToCartBtns = By.xpath("(//button[@class])["+i+"]");
            Utility.clickEle(driver,addToCartBtns);

        }
        return this ;
    }

   public String getCountCart() {
       try {
           LogUtility.info("Count of products on cart: "+Utility.getTextEle(driver, iconCartCount));
           return Utility.getTextEle(driver, iconCartCount);

       }catch (Exception e)
       {
           LogUtility.error(e.getMessage());
       }
       return "0" ;
   }

    public String getSelectedProducts()
    {
        try {
            selectedProd = driver.findElements(selectedProducts);
            LogUtility.info("Count of Products are selected : "+String.valueOf(selectedProd.size()));
            return String.valueOf(selectedProd.size());

        }catch (Exception e)
        {
            LogUtility.error(e.getMessage());
        }
        return "0";
    }


    public boolean compareCountCartWithSelectedProd()
    {
        return getCountCart().equals(getSelectedProducts());
    }



}
