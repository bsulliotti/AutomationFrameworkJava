package ObjectRepository;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class User_Menu {
    private static WebElement element = null;

    public static WebElement UMen_UserMenu(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[1]/ng-include/div/ul/li[6]/a/span"));
        return element;
    }

    public static WebElement UMen_LogOutAzure(WebDriver driver){
        element = driver.findElement(By.cssSelector("#logOutAzureBtn > span:nth-child(2)"));
        return element;
    }

    public static WebElement UMen_ManageVTenants(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[1]/ng-include/div/div[4]/div/div[2]/div/ul/li[6]/a/span"));
        return element;
    }
}
