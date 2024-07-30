package Pages;

import Utilities.LogUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_finishOrder {

    private final WebDriver driver;

    public P07_finishOrder(WebDriver driver) {
        this.driver = driver ;
    }

    private final By textMsg = By.tagName("h2");



    public boolean checkVisibilityOfMSG()
    {
        LogUtility.info("msg : "+driver.findElement(textMsg).getText());
        return driver.findElement(textMsg).isDisplayed();
    }





}
