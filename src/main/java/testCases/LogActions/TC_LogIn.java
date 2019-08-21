package testCases.LogActions;

import appModules.LogOut_Action;
import appModules.SignIn_Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ObjectRepository.Home_Page;
import ObjectRepository.User_Reports;
import utility.Constant;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class TC_LogIn {

    private static WebDriver driver = null;

    @BeforeClass
    public void OpenBrowser (){
        System.setProperty("webdriver.chrome.driver","binaries/geckodriver"); //this setup works for MAC
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void teardown (){
        driver.quit();
    }

    @Test
    public void LogIn (){
        driver.get(Constant.URL);
        SignIn_Action.Execute(driver, Constant.Username, Constant.Password);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement DashBoardItem= driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div[2]/div[1]/div/div/div[1]"));
        Assert.assertTrue (DashBoardItem.isDisplayed());
        System.out.println("Login Successfully, dashboard loaded correctly");

    }

    @Test
    public void TC_1688 (){
        driver.get(Constant.URL);
        SignIn_Action.Execute(driver, Constant.Username, Constant.Password);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement DashBoardItem= driver.findElement(By.xpath("//*[@id=\"dashboard\"]/div[2]/div[1]/div/div/div[1]"));
        Assert.assertTrue (DashBoardItem.isDisplayed());
        System.out.println("Login Successfully, dashboard loaded correctly");
    }

    @Test
    public void LoadPage(){
        driver.get(Constant.URL);
        Assert.assertEquals(driver.getCurrentUrl(),"https://cvstgauth.azurewebsites.net/login?returnUrl=https:%2F%2Fstaging.coreview.com");
    }

    @Test (dependsOnMethods = "LoadPage")
    public void TC_1689 (){
        SignIn_Action.Execute(driver, Constant.Username, Constant.Password);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Home_Page.Hp_UserReports(driver).click();
        Home_Page.Hp_UrepUsers(driver).click();
        User_Reports.Urep_UserName(driver).click();
        WebElement UserReportTest = driver.findElement(By.xpath("//*[@id=\"users\"]/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[1]/td[5]/div"));
        Assert.assertTrue (UserReportTest.isDisplayed());
    }

    @Test
    public void LogOut() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constant.URL);
        SignIn_Action.Execute(driver, Constant.Username, Constant.Password);
        LogOut_Action.Execute(driver);
        Assert.assertEquals(driver.getCurrentUrl(),"https://login.microsoftonline.com/common/oauth2/logout?post_logout_redirect_uri=https://staging.coreview.com");
    }


}
