package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static void setup(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                threadLocal.set(new ChromeDriver(options));
                break;
            case "firefox":
                threadLocal.set(new FirefoxDriver());
                break;
            default:
                EdgeOptions options1=new EdgeOptions();
                options1.addArguments("--start-maximized");
                threadLocal.set(new EdgeDriver(options1));
        }

    }
    public static WebDriver getDriver()
    {
        // threadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return threadLocal.get() ;
    }

    public static void tearDown()
    {
        getDriver().quit();
        threadLocal.remove();
    }




}
