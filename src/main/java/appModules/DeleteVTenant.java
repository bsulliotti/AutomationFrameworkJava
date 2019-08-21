package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import ObjectRepository.Manage_VTenants;

import java.util.concurrent.TimeUnit;

public class DeleteVTenant {

@AfterTest //TestCase Delete 1860
    public static void Execute (WebDriver driver){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement SearchField = driver.findElement(By.xpath("//*[@id=\"column_filter_0\"]/div/input"));
        SearchField.sendKeys("TC 1839", Keys.ENTER);
        BlockUI_Wait.Execute(driver);
        WebElement DeleteButton = driver.findElement(By.cssSelector("span.ms-Icon--Delete"));
        BlockUI_Wait.Execute(driver);
        DeleteButton.click();
        Manage_VTenants.VT_ConfDeletion(driver).click();
    }
}
