package appModules;

import org.openqa.selenium.WebDriver;
import ObjectRepository.LogIn_Page;

import java.util.concurrent.TimeUnit;

public class SignIn_Action {

    public static void Execute (WebDriver driver, String sUsername, String sPassword) {

        LogIn_Page.btn_LogIn(driver).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        LogIn_Page.txtbx_UserName(driver).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        LogIn_Page.txtbx_UserName(driver).sendKeys(sUsername);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        LogIn_Page.btn_NextLgn(driver).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        LogIn_Page.txtbx_Password(driver).sendKeys(sPassword);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        LogIn_Page.btn_NextLgn(driver).click();

        LogIn_Page.btn_NextLgn(driver).click();

        LogIn_Page.btn_Back(driver).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }
}

