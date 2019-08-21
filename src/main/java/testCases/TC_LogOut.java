package testCases;

import appModules.LogOut_Action;
import appModules.SignIn_Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.Constant;
import java.util.concurrent.TimeUnit;

public class TC_LogOut {

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
    public void LogOut() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constant.URL);
        SignIn_Action.Execute(driver, Constant.Username, Constant.Password);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LogOut_Action.Execute(driver);
        Assert.assertEquals(driver.getCurrentUrl(),"https://login.microsoftonline.com/common/oauth2/logout?post_logout_redirect_uri=https://staging.coreview.com");
    }
}