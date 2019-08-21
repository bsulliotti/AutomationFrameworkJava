package testCases;

import java.util.concurrent.TimeUnit;

import appModules.BlockUI_Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;// Import package pageObject.*
import appModules.SignIn_Action;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.Constant;


public class TC_1688 {

    private static WebDriver driver = null;

         @BeforeTest
         public void OpenBrowser (){

             System.setProperty("webdriver.gecko.driver", "binaries/geckodriver"); //this setup works for MAC

             FirefoxBinary firefoxBinary = new FirefoxBinary();
             firefoxBinary.addCommandLineOptions("-headless");

             FirefoxOptions firefoxOptions = new FirefoxOptions();
             firefoxOptions.setBinary(firefoxBinary);

             FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
             driver.get(Constant.URL);
             System.out.println("Headless Mode executing Correctly");
         }

        @AfterTest
                public void teardown (){
            driver.quit();
        }

        @Test
         public void LogIn (){
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            SignIn_Action.Execute(driver, Constant.Username, Constant.Password);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            BlockUI_Wait.Execute(driver);
            WebElement DashBoardItem= driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div[2]/div[1]/div/div/div[1]"));
            Assert.assertTrue (DashBoardItem.isDisplayed());
            System.out.println("Login Successfully, dashboard loaded correctly");
            driver.quit();
    }

}
