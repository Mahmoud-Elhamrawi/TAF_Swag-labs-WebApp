package Pages;

import Utilities.LogUtility;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_CheckoutOverViewPage {

    public WebDriver driver ;
    public P06_CheckoutOverViewPage(WebDriver driver)
    {
        this.driver = driver ;
    }
    private final By subTotal = By.className("summary_subtotal_label");
    private final By tax = By.className("summary_tax_label");
    private final By totalPrice = By.className("summary_total_label");
    private final By finishBtn = By.xpath("//button[contains(@class,'cart_button')]");


    public Float getSubTotalPrice()
    {
        LogUtility.info("subTotal : "+Utility.getTextEle(driver,subTotal).replace("Item total: $",""));

        return Float.parseFloat(Utility.getTextEle(driver,subTotal).replace("Item total: $",""));
    }
    public Float getTax()
    {
        LogUtility.info("TAX : "+Utility.getTextEle(driver,tax).replace("Tax: $",""));
        return Float.parseFloat(Utility.getTextEle(driver,tax).replace("Tax: $",""));
    }
    public Float getTotalPrice()
    {
        LogUtility.info("Total Price : "+Utility.getTextEle(driver,totalPrice).replace("Total: $",""));

        return Float.parseFloat(Utility.getTextEle(driver ,totalPrice).replace("Total: $",""));
    }
    public String calcTotalPrice()
    {
        LogUtility.info("Get total price :" + getSubTotalPrice() + getTax());
        return String.valueOf((getSubTotalPrice()) + (getTax()));
    }

    public boolean compareTotalPriceWithGetTotal()
    {
        return calcTotalPrice().equals(String.valueOf(getTotalPrice()));
    }

    public P07_finishOrder navigateToFinishOrder()
    {
        Utility.clickEle(driver,finishBtn);
        return new P07_finishOrder(driver);
    }









}
