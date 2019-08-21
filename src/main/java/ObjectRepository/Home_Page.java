package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {

    private static WebElement element = null;

    public static WebElement Hp_Dashboard (WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div[1]/div[1]/div/span/div/span"));
        return element;
    }

    public static WebElement Hp_UserReports (WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/ul/li[8]"));
        return element;
    }

     public static WebElement Hp_UrepUsers (WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"menuSidebar\"]/div/div/ul/li[8]/ul/li[1]/a"));
        return element;
    }

    public static WebElement Hp_Usermenu (WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"toggleProfileBar\"]/a/span"));
        return element;
    }

}