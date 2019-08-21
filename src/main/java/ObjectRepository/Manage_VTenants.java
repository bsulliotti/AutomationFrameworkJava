package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Manage_VTenants {
    private static WebElement element = null;

    // Work Items
    public static WebElement VT_Manage(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"manageVTenants\"]/div[2]/div/div/div[1]/div/div[1]/a/span"));
        return element;
    }
    public static WebElement VT_AddNew(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"manageVTenants\"]/div[2]/div/div/div[1]/div/div[1]/ul/li[1]/a"));
        return element;

    }
    public static WebElement VT_Export(WebDriver driver){
        element = driver.findElement(By.cssSelector("ul.dropdown-menu:nth-child(2) > li:nth-child(3) > a:nth-child(1)"));
        return element;
    }
    public static WebElement VT_Name(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"tab_general_info\"]/form/div[1]/input"));
        return element;
    }
    public static WebElement VT_Accept(WebDriver driver){
        element = driver.findElement(By.cssSelector("#vTenant > div.row > div > div > div.pull-right > button.btn.btn-info.ng-scope"));
        return element;
    }
    public static WebElement VT_Continue(WebDriver driver){
        element = driver.findElement(By.cssSelector("#confirmModal > div > div > div.modal-footer > button.btn.btn-info.ng-scope"));
        return element;
    }
    public static WebElement VT_ConfDeletion (WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"modalConfirmDelete\"]/div/div/div[3]/button[2]"));
        return element;
    }
    public static WebElement VT_Checkbox (WebDriver driver){
        element = driver.findElement(By.cssSelector("em.ng-scope"));
        return element;
    }

    //Search Fields
    public static WebElement VTSearchField (WebDriver driver){ //MEMBERS SEARCH FIELD
        element = driver.findElement(By.xpath("//*[@id=\"tab_operators_members\"]/div/div[1]/table/thead/tr[2]/th[2]/div/input"));
        return element;
    }
    public static WebElement VTSearchField2 (WebDriver driver){ //GROUPS SEARCH FIELD
        element = driver.findElement(By.xpath("//*[@id=\"column_filter_0\"]/div/input"));
        return element;
    }

    // VTenants Manage Tab Options
    public static WebElement VTOperators (WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"vTenant\"]/div[1]/div/div/div[1]/ul/li[2]/a"));
        return element;
    }
    public static WebElement VTUsers (WebDriver driver){
        element = driver.findElement(By.cssSelector("#usersBtn"));
        return element;
    }
    public static WebElement VTDistributionGroups(WebDriver driver){
        element = driver.findElement(By.cssSelector("ul.nav:nth-child(2) > li:nth-child(4) > a:nth-child(1)"));
        return element;
    }
    public static WebElement VTTenants (WebDriver driver){
        element = driver.findElement(By.cssSelector("ul.nav:nth-child(2) > li:nth-child(5) > a:nth-child(1)"));
        return element;
    }

    // Add items for each WebElement
    public static WebElement VTAddItem (WebDriver driver){ //Add for Members Items
        element = driver.findElement(By.xpath("//*[@id=\"tab_operators_members\"]/div/div[1]/table/tbody/tr/td[1]/i"));
        return element;
    }
    public static WebElement VTAddItem2 (WebDriver driver){ //Add for Operators Items
        element = driver.findElement(By.cssSelector("#operatorsDistributionGroupsTableBtn0_0 > span:nth-child(1)"));
        return element;
    }
    public static WebElement VTAddItem3 (WebDriver driver){ //Add for User Option - Domains
        element = driver.findElement(By.xpath("//*[@id=\"tab_users_domain\"]/div/div[1]/table/tbody/tr[1]/td[1]/i"));
        return element;
    }
    public static WebElement VTAddItem4 (WebDriver driver){ //Add user with ID/CSS Selector update
        element = driver.findElement(By.cssSelector("#tab_users_groups_distribution > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > span:nth-child(1)"));
        return element;
    }
    public static WebElement VTAddItem5 (WebDriver driver){ //Add User with Security Groups
        element = driver.findElement(By.cssSelector("#tab_users_groups_security > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > span:nth-child(1)"));
        return element;
    }
    public static WebElement VTAddItem6 (WebDriver driver){ //Add User with Office 365
        element = driver.findElement(By.cssSelector("#tab_users_groups_office365 > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(1) > span:nth-child(1)"));
        return element;
    }
    public static WebElement VTAddItem7 (WebDriver driver){ //Add User with Office 365
        element = driver.findElement(By.cssSelector("#tab_distribution_groups_domain > div:nth-child(1) > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > i:nth-child(1)"));
        return element;
    }
    public static WebElement VTAddItem8 (WebDriver driver){ //Add User for Tenant tab
        element = driver.findElement(By.cssSelector("#tab_tenants > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(1) > i:nth-child(1)"));
        return element;
    }

    // VTenants Operator Options
    public static WebElement VT_OPGroups (WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"tab_operators\"]/div/div/ul/li[2]/a"));
        return element;
    }
    public static WebElement VT_OPSecGroups (WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"tab_operators_groups\"]/div/div[1]/div/div/ul/li[2]/a"));
        return element;
    }
    public static WebElement VT_OPOff365 (WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"tab_operators_groups\"]/div/div[1]/div/div/ul/li[3]/a"));
        return element;
    }

    // VTenants User Options
    public static WebElement VT_UDomFil (WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"tab_users\"]/div/div/ul/li[1]/a"));
        return element;
    }
    public static WebElement VT_UGroups (WebDriver driver){
        element = driver.findElement(By.cssSelector("#usersGroupsBtn"));
        return element;
    }
    public static WebElement VT_USecGroups (WebDriver driver){
        element = driver.findElement(By.cssSelector("#tab_users_groups > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)"));
        return element;
    }
    public static WebElement VT_UOffice365 (WebDriver driver){
        element = driver.findElement(By.cssSelector("#tab_users_groups > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)"));
        return element;
    }

    // VTenants Distribution Groups Options
    public static WebElement VT_DGDelegationFil (WebDriver driver){
        element = driver.findElement(By.cssSelector("#tab_distribution_groups > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)"));
        return element;
    }
    public static WebElement VT_DGAddFilter (WebDriver driver){
        element = driver.findElement(By.cssSelector("#tab_distribution_groups_filters > div:nth-child(2) > div:nth-child(1) > button:nth-child(1)"));
        return element;
    }

    // VTenant Tenant Options


}




