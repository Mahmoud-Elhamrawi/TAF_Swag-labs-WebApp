package Pages;

import Utilities.LogUtility;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class P02_HomePage {
    public final WebDriver driver;

    public P02_HomePage(WebDriver driver) {
        this.driver = driver ;
    }

    private final By addToCartBtns = By.xpath("//button[@class]");
    private final By iconCartCount = By.className("shopping_cart_badge");
    private final By selectedProducts = By.xpath("//button[.='Remove']") ;
    private final By cartIcon = By.className("shopping_cart_link");

    private final By priceForSelectedItem = By.xpath("//button[.='Remove']//preceding-sibling::div[@class=\"inventory_item_price\"]");
    public static List<WebElement> allProducts ;
    public static List<WebElement> selectedProd ;
    public static List<WebElement> priceSelectedProd ;
    static float price=0;

    public By iconCartEle()
    {
        return iconCartCount;
    }

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


    //add random products to cart
    public P02_HomePage addRandomProductsToCart(int need , int total)
    {
         Set<Integer> uniqeRandom =Utility.setRandoms(need,total);
         for (int random:uniqeRandom)
         {
             LogUtility.info("random number :"+random);
             By addToCartBtns = By.xpath("(//button[@class])["+random+"]");
             Utility.clickEle(driver,addToCartBtns);
         }

        return  this ;
    }

    //get price for selected products
    public String totalPriceOfSelectedItem()
    {
        try {
            priceSelectedProd = driver.findElements(priceForSelectedItem);
            for (int i=1;i<=priceSelectedProd.size();i++)
            {
                By priceOfSelectProds = By.xpath("(//button[.='Remove']//preceding-sibling::div[@class=\"inventory_item_price\"])["+i+"]");
                String totalPrice =  Utility.getTextEle(driver,priceOfSelectProds);
                price += Float.parseFloat(totalPrice.replace("$",""));

            }
            LogUtility.info("totalPriceOfSelectedItem : "+ price);
            return String.valueOf(price);
        }catch (Exception e)
        {
            LogUtility.error(e.getMessage());
        }
        return "0";
    }


    //go to cart page
    public P03_cartPage navigateToCartPage()
    {
        Utility.clickEle(driver,cartIcon);
        return new P03_cartPage(driver);
    }

    //verify on cart page url
    public  boolean verifyOnCartPage(String expectUrl)
    {
        return new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(expectUrl));
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
       // return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe())
    }



}
