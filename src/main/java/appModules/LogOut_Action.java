package appModules;

import ObjectRepository.User_Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.testng.Assert;

public class LogOut_Action {

    public static void Execute (WebDriver driver){

        User_Menu.UMen_UserMenu(driver).click();
        User_Menu.UMen_LogOutAzure(driver).click();
    }
}
