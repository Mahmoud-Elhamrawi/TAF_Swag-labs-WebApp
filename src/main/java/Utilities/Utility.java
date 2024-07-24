package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utility {

    //TODO::click on ele
    public static void clickEle(WebDriver driver , By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    //TODO::send text
    public static void sendText(WebDriver driver , By locator , String  text)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    //TODO::get text from Element
     public static String getTextEle(WebDriver driver , By locator)
     {
         new WebDriverWait(driver , Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
         return driver.findElement(locator).getText();

     }

    //TODO::scrolling
    public static void scrollTOEle(WebDriver driver , By locator)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
    }

    //TODO::Take screen shots
    public static String screen_Path ="tests-outputs/screen-shots/";
    public static void takeScreenShot(WebDriver driver , String screenNane) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dis = new File(screen_Path+screenNane+"_"+timeStemp()+".png");
        FileUtils.copyFile(src,dis);
    }

    //TODO::time stemp
        public static String timeStemp()
        {
            return new SimpleDateFormat("yyyy-MM--dd || h:m:ss a").format(new Date());
        }

     //TODO::select-options
     public static void selectOption(WebDriver driver , By locator , String option){
            new Select(driver.findElement(locator)).selectByVisibleText(option);
        }
     //TODO:generate random numbers
      public static int randomNumbs(int upper)
      {
          return new Random().nextInt(upper);
      }

       public static Set<Integer> setRandoms(int need , int total)
       {
           Set<Integer> setNumbers = new HashSet<>();
           while (setNumbers.size()<need)
           {
               int random  = randomNumbs(total);
               setNumbers.add(random);
           }
           return setNumbers ;
       }


}
