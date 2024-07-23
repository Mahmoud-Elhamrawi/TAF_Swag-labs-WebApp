package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    public WebDriver driver;

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By usernameInp = By.id("user-name");
    private final By userPasswordInp = By.id("password");
    private final By loginBtn = By.id("login-button");


    public P01_LoginPage enterUserName(String userName) {
        Utility.sendText(driver, usernameInp, userName);
        return this;
    }

    public P01_LoginPage enterUserPassword(String userPassword) {
        Utility.sendText(driver, userPasswordInp, userPassword);
        return this;
    }

    public P02_HomePage clickLoginBtn()
    {
        Utility.clickEle(driver,loginBtn);
        return new P02_HomePage(driver);
    }

    public boolean assertUrl(String expectUrl)
    {
        return driver.getCurrentUrl().equals(expectUrl);
    }

}