package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ObjectRepository.Manage_VTenants;
import org.openqa.selenium.WebDriver;

public class Save_Action {

    public static void Execute (WebDriver driver){

        Manage_VTenants.VT_Accept(driver).click();
        Manage_VTenants.VT_Continue(driver).click();
        WebElement SuccessMessage = driver.findElement(By.xpath("//*[@id=\"toast-container\"]"));
        Assert.assertTrue(SuccessMessage.isDisplayed());
        BlockUI_Wait.Execute(driver);
    }
}

