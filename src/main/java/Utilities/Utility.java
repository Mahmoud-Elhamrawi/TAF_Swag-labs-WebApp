package Utilities;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class Utility {
    //tests-outputs/screen_shoots
    public static final String screen_Path ="tests-outputs/screen_shoots/";

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

    public static void takeScreenShot(WebDriver driver , String screenName) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dis = new File(screen_Path + screenName + "_" +timeStemp()+".png");
        FileUtils.copyFile(src,dis);
    }

    //TODO:take ful screen shots
    public static void takeFullScreenShot(WebDriver driver , By locator)
    {
        try {
            Shutterbug.shootPage(driver, Capture.FULL_SCROLL)
                    .highlight(driver.findElement(locator))
                    .save(screen_Path);
        }catch (Exception e)
        {
            LogUtility.error(e.getMessage());
        }
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
          return new Random().nextInt(upper)+1;
      }

       public static Set<Integer> setRandoms(int needNum , int totalNum)
       {
           Set<Integer> setNumbers = new HashSet<>();
           while (setNumbers.size()<needNum)
           {
               int random  = randomNumbs(totalNum);
               setNumbers.add(random);
           }
           return setNumbers ;
       }

//function to get latest file in logs
    public static File getLatestFile(String path)
    {
        File file = new File(path);
        File[] files =file.listFiles();
        assert files != null;
        if(files.length==0)
            return null;
        Arrays.sort(files,Comparator.comparingLong(File::lastModified).reversed());
        return files[0];
    }

    //add cookies
    public static Set<Cookie> getAllCookies(WebDriver driver)
    {
        return driver.manage().getCookies();
    }

    public static void restoreCookies(WebDriver driver , Set<Cookie> cookies)
    {
        for (Cookie cookie:cookies)
            driver.manage().addCookie(cookie);
    }



}
