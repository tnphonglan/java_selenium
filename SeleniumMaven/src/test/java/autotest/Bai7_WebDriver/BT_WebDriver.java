package autotest.Bai7_WebDriver;

import autotest.Bai5_Locators.BT_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BT_WebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/clients");

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        driver.findElement(By.xpath(LocatorsCRM.menuProjects)).click();
        driver.findElement(By.xpath(LocatorsCRM.buttonNewProject)).click();

        //Add New Project
        driver.findElement(By.xpath(LocatorsCRM.inputProjectName)).sendKeys("Project demo");
        driver.findElement(By.xpath(LocatorsCRM.dropdownCustomer)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownCustomer)).click();
        //driver.findElement(By.xpath(LocatorsCRM.checkboxCalculateProgress)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownBillingType)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownBillingType)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownStatus)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownStatus)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputRatePerHour)).sendKeys("5");
        driver.findElement(By.xpath(LocatorsCRM.inputEstimatedHours)).sendKeys("5");
        driver.findElement(By.xpath(LocatorsCRM.dropdownMembers)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownMembers)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputStartDate)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputStartDate)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputDeadline)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputDeadline)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownTags)).click();
        driver.findElement(By.xpath(LocatorsCRM.dropdownTags)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputDescription)).sendKeys("Auto test");
        driver.findElement(By.xpath(LocatorsCRM.buttonSaveProject)).click();

        Thread.sleep(1000);
        driver.quit();
    }
}
