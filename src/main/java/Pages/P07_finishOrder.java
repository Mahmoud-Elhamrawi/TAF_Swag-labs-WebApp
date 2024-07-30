package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_finishOrder {

    private final WebDriver driver;

    public P07_finishOrder(WebDriver driver) {
        this.driver = driver ;
    }

    private final By finishOrderBtn = By.id("finish");



    public boolean checkVisibilityOfMSG()
    {
        return driver.findElement(By.tagName("finish")).isDisplayed();
    }





}
