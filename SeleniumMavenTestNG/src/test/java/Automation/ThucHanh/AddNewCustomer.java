package Automation.ThucHanh;

import Automation.common.BaseTest;
import Automation.common.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewCustomer extends BaseTest {

    String COMPANY_NAME = "VietMap 01";

    public void loginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).isDisplayed(),"Menu Dashboard not displayed.");
    }

    public void openCustomerPage(){
        loginCRM();
        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerCustomerPage)).isDisplayed(),"Header Customer Page not displayed.");
    }
    @Test
    public void testAddNewCustomer(){
        openCustomerPage();

        driver.findElement(By.xpath(LocatorsCRM.buttonAddNewCustomers)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys(COMPANY_NAME);
        driver.findElement(By.xpath(LocatorsCRM.inputVAT)).sendKeys("10");
        driver.findElement(By.xpath(LocatorsCRM.inputPhone)).sendKeys("0977469144");
        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("vietmap.vn");
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroup)).sendKeys("VIP");
        sleep(1);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroup)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).sendKeys("USD");
        sleep(1);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
        //driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputAddress)).sendKeys("197 Trần Phú");
        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("Hồ Chí Minh");
        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("");
        driver.findElement(By.xpath(LocatorsCRM.inputZipCode)).sendKeys("");
        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Vietnam");
        sleep(1);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys(Keys.ENTER);
        sleep(2);
        driver.findElement(By.xpath(LocatorsCRM.buttonSaveCustomer)).click();
        sleep(2);
        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        sleep(3);
        driver.findElement(By.xpath(LocatorsCRM.buttonSearchCustomers)).sendKeys(COMPANY_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).getText(),COMPANY_NAME);
    }

    @Test
    public void testAddNewContact(){
        openCustomerPage();
        driver.findElement(By.xpath(LocatorsCRM.buttonSearchCustomers)).sendKeys(COMPANY_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).getText(),COMPANY_NAME);
        sleep(2);
        driver.findElement(By.xpath(LocatorsCRM.firstItemCustomerOnTable)).click();
        driver.findElement(By.xpath(LocatorsCRM.menuContacts)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerContactPage)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerContactPage)).getText(),"Contacts");
        driver.findElement(By.xpath(LocatorsCRM.buttonAddNewContact)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.headerAddNewContactDialog)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerAddNewContactDialog)).getText(),"Add new contact");
        sleep(2);
        driver.findElement(By.xpath(LocatorsCRM.inputProfileImage)).sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\Datatest\\profile_contact.jpg");
        sleep(2);
        driver.findElement(By.xpath(LocatorsCRM.inputFirstName)).sendKeys("Lan");
        driver.findElement(By.xpath(LocatorsCRM.inputLastName)).sendKeys("Tran");
        driver.findElement(By.xpath(LocatorsCRM.inputPosition)).sendKeys("Tester");
        driver.findElement(By.xpath(LocatorsCRM.inputEmailContact)).sendKeys("tnphonglan@gmail.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPhoneContact)).sendKeys("977469144");
        driver.findElement(By.xpath(LocatorsCRM.buttonGeneratePassword)).click();
        driver.findElement(By.xpath(LocatorsCRM.buttonShowPassword)).click();
        sleep(2);
        String passValue = driver.findElement(By.xpath(LocatorsCRM.inputPasswordContact)).getAttribute("value");
        System.out.println(passValue);
        driver.findElement(By.xpath(LocatorsCRM.checkboxDoNotSendEmail)).click();
        driver.findElement(By.xpath(LocatorsCRM.buttonSaveContact)).click();

        //driver.findElement(By.xpath(LocatorsCRM.inputSearchContacts)).sendKeys("Lan Tran");
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.firstItemContactOnTable)).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.firstItemContactOnTable)).getText(),"Lan Tran");
        
    }
}
