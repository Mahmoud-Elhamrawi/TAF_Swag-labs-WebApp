package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P04_checkoutPage {
    private final WebDriver driver;
    private final By firstNameInp = By.id("first-name");
    private  final By lastNameINp = By.id("last-name");
    private final By zipCodeInp = By.id("postal-code");
    private final By continueBtn =By.id("continue");
    public P04_checkoutPage(WebDriver driver) {
        this.driver= driver ;
    }

    public  P04_checkoutPage fillInfoData(String fName , String lName , String zipCode)
    {
        Utility.sendText(driver ,firstNameInp , fName);
        Utility.sendText(driver ,lastNameINp , lName);
        Utility.sendText(driver ,zipCodeInp , zipCode);

        return  this ;
    }

    public P05_continuePage clickOnContinueBtn()
    {
        Utility.clickEle(driver ,continueBtn);
        return new P05_continuePage(driver);
    }

    public boolean verifyUrl(String url)
    {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(url));
    }



}
