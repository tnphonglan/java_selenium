package autotest.Bai6_WebElement;

import autotest.Bai5_Locators.BT_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BT_WebElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/clients");

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorsCRM.buttonAddNewCustomers)).click();

         //Add new customer
        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys("Company");
        driver.findElement(By.xpath(LocatorsCRM.inputVAT)).sendKeys("8");
        driver.findElement(By.xpath(LocatorsCRM.inputPhone)).sendKeys("12345678");
        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("https://anhtester.com/");
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        //driver.findElement(By.xpath(LocatorsCRM.inputSearchGroup)).sendKeys("Automation");
        driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
        //driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).sendKeys("USD");
        driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputAddress)).sendKeys("197 Trần Phú");
        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("Hồ Chí Minh");
        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("New");
        driver.findElement(By.xpath(LocatorsCRM.inputZipCode)).sendKeys("123");
        driver.findElement(By.xpath(LocatorsCRM.buttonSaveCustomer)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
        //driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Vietnam");

        Thread.sleep(5000);
        driver.quit();
    }
}
