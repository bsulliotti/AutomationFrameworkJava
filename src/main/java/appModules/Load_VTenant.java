package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Load_VTenant {

        public static void Execute (WebDriver driver){

            WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
            TestTenant.click();
        }
}
