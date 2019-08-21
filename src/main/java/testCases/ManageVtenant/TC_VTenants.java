package testCases.ManageVtenant;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;
import appModules.BlockUI_Wait;
import appModules.DeleteVTenant;
import appModules.Save_Action;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import appModules.SignIn_Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ObjectRepository.Manage_VTenants;
import ObjectRepository.User_Menu;
import utility.Constant;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TC_VTenants {

    private static WebDriver driver = null;

    @BeforeClass
    public void OpenBrowser (){

        System.setProperty("webdriver..driver","binaries/geckodriver"); //this setup works for MAC
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void teardown (){
        DeleteVTenant.Execute(driver);
        driver.quit();
    }

    @Test
    public void TC_1839 (){
        driver.get(Constant.URL);
        SignIn_Action.Execute(driver, Constant.Username, Constant.Password);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/ng-include/div/ul/li[6]/a/span")));
        User_Menu.UMen_UserMenu(driver).click();
        User_Menu.UMen_ManageVTenants(driver).click();
        BlockUI_Wait.Execute(driver);
        WebElement LoadTenants = driver.findElement(By.xpath("//*[@id=\"manageVTenants\"]"));
        Assert.assertTrue(LoadTenants.isDisplayed());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VT_Manage(driver).click();
        Manage_VTenants.VT_AddNew(driver).click();
        WebElement LoadedPage = driver.findElement(By.xpath("//*[@id=\"tab_general_info\"]/form/div[1]/input"));
        Assert.assertTrue(LoadedPage.isDisplayed());
        Manage_VTenants.VT_Name(driver).sendKeys("TC 1839 Tenant Creation");
        BlockUI_Wait.Execute(driver);
        Save_Action.Execute(driver);
    }

    @Test (dependsOnMethods = "TC_1839") //Add Members Test Case
    public void TC_1840 (){
        driver.get(Constant.VTenantURL);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.linkText("TC 1839 Tenant Creation")));
        TestTenant.click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTOperators(driver).click();
        Manage_VTenants.VTSearchField(driver).sendKeys("Automation Do Not Delete");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Manage_VTenants.VTAddItem(driver).click();
        Save_Action.Execute(driver);
    }

    @Test (dependsOnMethods = "TC_1839") //Add Distribution Groups Test Case
    public void TC_1841 (){
        driver.get(Constant.VTenantURL);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
        BlockUI_Wait.Execute(driver);
        TestTenant.click();
        BlockUI_Wait.Execute(driver);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(Manage_VTenants.VTOperators(driver)));
        Manage_VTenants.VTOperators(driver).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Manage_VTenants.VT_OPGroups(driver).click();
        Manage_VTenants.VTSearchField2(driver).sendKeys("DG Group01", Keys.ENTER);
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTAddItem2(driver).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        BlockUI_Wait.Execute(driver);
        Save_Action.Execute(driver);
    }

    @Test (dependsOnMethods = "TC_1839") //Add Security Group Test Case
    public void TC_1842 (){
        driver.get(Constant.VTenantURL);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
        BlockUI_Wait.Execute(driver);
        TestTenant.click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTOperators(driver).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Manage_VTenants.VT_OPGroups(driver).click();
        BlockUI_Wait.Execute(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Manage_VTenants.VT_OPSecGroups(driver).click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTAddItem(driver).click();Save_Action.Execute(driver);
        BlockUI_Wait.Execute(driver);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement Element = driver.findElement(By.cssSelector("#operatorsSecurityGroupsTableBtn8_0 > span:nth-child(1)"));
        Element.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        BlockUI_Wait.Execute(driver);
        Save_Action.Execute(driver);
    }

    @Test (dependsOnMethods = "TC_1839") //Add Office 365 Group Test Case
    public void TC_1843 (){
        driver.get(Constant.VTenantURL);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        BlockUI_Wait.Execute(driver);
        WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
        BlockUI_Wait.Execute(driver);
        TestTenant.click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTOperators(driver).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Manage_VTenants.VT_OPGroups(driver).click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VT_OPOff365(driver).click();
        BlockUI_Wait.Execute(driver);

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement Element = driver.findElement(By.cssSelector("#operatorsOffice365GroupsTableBtn8_0 > span:nth-child(1)"));
        Element.isDisplayed();

        BlockUI_Wait.Execute(driver);
        Save_Action.Execute(driver);
    }

    @Test (dependsOnMethods = "TC_1839") //Add User Domain Test Case
    public void TC_1844 (){
        driver.get(Constant.VTenantURL);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        BlockUI_Wait.Execute(driver);
        WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
        TestTenant.click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTUsers(driver).click();WebElement Add = driver.findElement(By.xpath("//*[@id=\"tab_users_domain\"]/div/div[1]/table/tbody/tr[3]/td[1]/i"));
        Add.click();Manage_VTenants.VTAddItem3(driver).click();
        BlockUI_Wait.Execute(driver);
        Save_Action.Execute(driver);
    }

    @Test (dependsOnMethods = "TC_1839") //Add Delegation Filters Test Case
    public void TC_1845 (){
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        BlockUI_Wait.Execute(driver);
        WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
        TestTenant.click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTUsers(driver).click();
        Manage_VTenants.VT_UDomFil(driver).click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTAddItem3(driver).click();
        BlockUI_Wait.Execute(driver);
        Save_Action.Execute(driver);
    }

    @Test (dependsOnMethods = "TC_1839") //Add User Distribution Groups Test Case **
    public void TC_1846 (){
        driver.get(Constant.VTenantURL);
        BlockUI_Wait.Execute(driver);
        WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
        BlockUI_Wait.Execute(driver);
        TestTenant.click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTUsers(driver).click();
        Manage_VTenants.VT_UGroups(driver).click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTAddItem4(driver).click();
        BlockUI_Wait.Execute(driver);
        Save_Action.Execute(driver);
    }

    @Test (dependsOnMethods = "TC_1839") //Add Users Groups Security Groups Test Case
    public void TC_1847 (){
        driver.get(Constant.VTenantURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BlockUI_Wait.Execute(driver);
        TestTenant.click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTUsers(driver).click();
        Manage_VTenants.VT_UGroups(driver).click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VT_USecGroups(driver).click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTAddItem5(driver).click();
        BlockUI_Wait.Execute(driver);
        Save_Action.Execute(driver);
    }

    @Test (dependsOnMethods = "TC_1839") //Add Users Groups Office365 Groups Test Case
    public void TC_1848 (){
        driver.get(Constant.VTenantURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
        TestTenant.click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTUsers(driver).click();
        Manage_VTenants.VT_UGroups(driver).click();
        BlockUI_Wait.Execute(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Manage_VTenants.VT_UOffice365(driver).click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTAddItem6(driver).click();
        BlockUI_Wait.Execute(driver);
        Save_Action.Execute(driver);
    }

    @Test (dependsOnMethods = "TC_1839") //Add Distribution Groups Domain Filters Test Case
    public void TC_1849 (){
        driver.get(Constant.VTenantURL);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        BlockUI_Wait.Execute(driver);
        WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        BlockUI_Wait.Execute(driver);
        TestTenant.click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTDistributionGroups(driver).click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTAddItem7(driver).click();
        BlockUI_Wait.Execute(driver);
        Save_Action.Execute(driver);
    }

   @Test (dependsOnMethods = "TC_1839") //Distribution Groups Delegation Filters Test Case ** GOTTA UPDATE THE FILTERS BECAUSE I NEED TO SELECT OPTION FROM THE DROPDOWN MENU
    public void TC_1850 (){
        driver.get(Constant.VTenantURL);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
        BlockUI_Wait.Execute(driver);
        TestTenant.click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTDistributionGroups(driver).click();
        Manage_VTenants.VT_DGDelegationFil(driver).click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VT_DGAddFilter(driver).click();
        BlockUI_Wait.Execute(driver);
        Save_Action.Execute(driver);
    }

    @Test (dependsOnMethods = "TC_1839") // Add Tenant to VTenants Test Case
    public void TC_1851 (){
        driver.get(Constant.VTenantURL);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
        TestTenant.click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTTenants(driver).click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTAddItem8(driver).click();
        BlockUI_Wait.Execute(driver);
        Save_Action.Execute(driver);
    }

    @Test (dependsOnMethods = "TC_1839") //Export VTenants Test Case ** Wait to see the Issue if the managment the VTenant Managment Issue
    public void TC_1861 (){
        driver.get(Constant.VTenantURL);
        WebElement SearchField = driver.findElement(By.xpath("//*[@id=\"column_filter_0\"]/div/input"));
        SearchField.sendKeys("TC 1839", Keys.ENTER);
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VT_Checkbox(driver).click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        Manage_VTenants.VT_Manage(driver).click();
        Manage_VTenants.VT_Export(driver).click();
        BlockUI_Wait.Execute(driver);

        Save_Action.Execute(driver);
    }

    @Test (dependsOnMethods = "TC_1839") //V-Tenant Import Test Case
    public void TC_1862 (){ //
        driver.get(Constant.VTenantURL);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement TestTenant = driver.findElement(By.linkText("TC 1839 Tenant Creation"));
        TestTenant.click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTUsers(driver).click();
        Manage_VTenants.VT_UDomFil(driver).click();
        BlockUI_Wait.Execute(driver);
        Manage_VTenants.VTAddItem3(driver).click();
        BlockUI_Wait.Execute(driver);
        Save_Action.Execute(driver);
    }
}

