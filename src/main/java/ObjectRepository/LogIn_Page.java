package ObjectRepository;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn_Page {

    private static WebElement element = null;

    public static WebElement txtbx_UserName (WebDriver driver){
        element = driver.findElement(By.id("i0116"));
        return element;
    }

    public static WebElement txtbx_Password(WebDriver driver){
        element = driver.findElement(By.id("i0118"));
        return element;
    }

    public static WebElement btn_NextLgn(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]"));
        return element;
    }

    public static WebElement btn_LogIn(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"contentLogin\"]/div[1]/form/div/button"));
        return element;
    }

    public static WebElement btn_Back (WebDriver driver){
        element = driver.findElement(By.id("idBtn_Back"));
        return element;
    }


}