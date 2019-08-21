package ObjectRepository;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class User_Reports {

    private static WebElement element = null;

    public static WebElement Urep_UserName (WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"users\"]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[1]/td[5]/div"));
        return element;
    }
}
