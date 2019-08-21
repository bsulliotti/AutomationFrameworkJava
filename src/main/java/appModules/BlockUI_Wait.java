package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlockUI_Wait {

    public static void Execute (WebDriver driver){

        try {
            Thread.sleep(1000); } catch(InterruptedException e) {
        }
        if (driver.findElement(By.cssSelector(".block-ui-overlay")).isDisplayed()){
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".block-ui-overlay")));
        }
    }
}


// CSS Selector Block UI creating VTenant : div.block-ui-container:nth-child(7)
// CSS Selector Block UI Opening VTenant : div.block-ui-container:nth-child(7)
// CSS Selector Block UI Overlay : .block-ui-ove
//.block-ui-overlay
//

//    if(driver.findElement(By.id("mainBody")).isDisplayed()){
//        new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.id("mainBody")));
//    }
//}