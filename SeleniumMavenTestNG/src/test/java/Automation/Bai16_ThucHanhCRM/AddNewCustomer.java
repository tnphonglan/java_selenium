package Automation.Bai16_ThucHanhCRM;

import Automation.common.BaseTest;
import Automation.common.LocatorsCRM;
import Automation.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddNewCustomer extends BaseTest {

    String COMPANY_NAME = "VietMap 01";

    public void loginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");

        WebUI.setText(LocatorsCRM.inputEmail, "admin@example.com");
        WebUI.setText(LocatorsCRM.inputPassword, "123456");
        WebUI.clickElement(LocatorsCRM.buttonLogin);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).isDisplayed(),"Menu Dashboard not displayed.");
    }

    public void openCustomerPage(){
        loginCRM();
        WebUI.clickElement(LocatorsCRM.menuCustomers);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerCustomerPage)).isDisplayed(),"Header Customer Page not displayed.");
    }
    @Test
    public void testAddNewCustomer(){
        openCustomerPage();

        WebUI.clickElement(LocatorsCRM.buttonAddNewCustomers);
        WebUI.setText(LocatorsCRM.inputCompany,COMPANY_NAME);
        WebUI.setText(LocatorsCRM.inputVAT, "10");
        WebUI.setText(LocatorsCRM.inputPhone,"0977469144");
        WebUI.setText(LocatorsCRM.inputWebsite, "vietmap.vn");
        WebUI.clickElement(LocatorsCRM.dropdownGroups);
        WebUI.setText(LocatorsCRM.inputSearchGroup,"VIP");
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroup)).sendKeys(Keys.ENTER);
        WebUI.clickElement(LocatorsCRM.dropdownGroups);
        WebUI.clickElement(LocatorsCRM.dropdownCurrency);
        WebUI.setText(LocatorsCRM.inputSearchCurrency,"USD");
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).sendKeys(Keys.ENTER);
        WebUI.clickElement(LocatorsCRM.dropdownCurrency);
        WebUI.setText(LocatorsCRM.inputAddress,"197 Trần Phú");
        WebUI.setText(LocatorsCRM.inputCity,"Hồ Chí Minh");
        WebUI.setText(LocatorsCRM.inputState,"123");
        WebUI.setText(LocatorsCRM.inputZipCode,"84");
        WebUI.clickElement(LocatorsCRM.dropdownCountry);
        WebUI.setText(LocatorsCRM.inputSearchCountry,"Vietnam");
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys(Keys.ENTER);
        WebUI.clickElement(LocatorsCRM.buttonSaveCustomer);
        WebUI.clickElement(LocatorsCRM.menuCustomers);
        WebUI.setText(LocatorsCRM.buttonSearchCustomers,COMPANY_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).getText(),COMPANY_NAME);
    }

    @Test
    public void testAddNewContact(){
        openCustomerPage();
        WebUI.setText(LocatorsCRM.buttonSearchCustomers, COMPANY_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).getText(),COMPANY_NAME);
        WebUI.clickElement(LocatorsCRM.firstItemCustomerOnTable);
        WebUI.clickElement(LocatorsCRM.menuContacts);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerContactPage)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerContactPage)).getText(),"Contacts");
        WebUI.clickElement(LocatorsCRM.buttonAddNewContact);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerAddNewContactDialog)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerAddNewContactDialog)).getText(),"Add new contact");
        driver.findElement(By.xpath(LocatorsCRM.inputProfileImage)).sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\Datatest\\profile_contact.jpg");
        WebUI.setText(LocatorsCRM.inputFirstName,"Lan");
        WebUI.setText(LocatorsCRM.inputLastName,"Tran");
        WebUI.setText(LocatorsCRM.inputPosition,"Tester");
        WebUI.setText(LocatorsCRM.inputEmailContact,"tnphonglan@gmail.com");
        WebUI.setText(LocatorsCRM.inputPhoneContact,"977469144");
        WebUI.clickElement(LocatorsCRM.buttonGeneratePassword);
        WebUI.clickElement(LocatorsCRM.buttonShowPassword);
        String passValue = driver.findElement(By.xpath(LocatorsCRM.inputPasswordContact)).getAttribute("value");
        driver.findElement(By.xpath(LocatorsCRM.checkboxDoNotSendEmail)).click();
        WebUI.clickElement(LocatorsCRM.buttonSaveContact);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.firstItemContactOnTable)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.firstItemContactOnTable)).getText(),"Lan Tran");

    }
}
