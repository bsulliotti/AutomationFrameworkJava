package testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import appModules.SignIn_Action;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.Constant;
import ObjectRepository.Home_Page;
import ObjectRepository.User_Reports;

public class TC_1689 {

    private static WebDriver driver = null;

        @BeforeClass
        public void OpenBrowser() {
            System.setProperty("webdriver.chrome.driver","binaries/geckodriver");
            driver = new FirefoxDriver();
            }

        @AfterClass
         public void teardown(){
             driver.quit();
            }

        @Test
         public void LoadPage(){
            driver.get(Constant.URL);
            Assert.assertEquals(driver.getCurrentUrl(),"https://cvstgauth.azurewebsites.net/login?returnUrl=https:%2F%2Fstaging.coreview.com");
        }

        @Test (dependsOnMethods = "LoadPage")
        public void LoadUserReports (){
            SignIn_Action.Execute(driver, Constant.Username, Constant.Password);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Home_Page.Hp_UserReports(driver).click();
            Home_Page.Hp_UrepUsers(driver).click();
            User_Reports.Urep_UserName(driver).click();
            WebElement UserReportTest = driver.findElement(By.xpath("//*[@id=\"users\"]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[1]/td[5]/div"));
            Assert.assertTrue (UserReportTest.isDisplayed());
        }
}