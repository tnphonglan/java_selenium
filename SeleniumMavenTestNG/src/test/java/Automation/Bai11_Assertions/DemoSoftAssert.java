package Automation.Bai11_Assertions;

import Automation.common.BaseTest;
import Automation.common.LocatorsCRM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert extends BaseTest {
    @Test
    public void testOpenProject() {

        SoftAssert softAssert = new SoftAssert();


        driver.get("https://crm.anhtester.com/admin/authentication");

        //Kiểm tra màn hình Login
        String hederLoginPage = driver.findElement(By.xpath(LocatorsCRM.headerLoginPage)).getText();
        softAssert.assertEquals(hederLoginPage, "Login", "Header Login page not match");

        String url = driver.getCurrentUrl();

        //So sánh bằng
        //Assert.assertEquals(url,"https://crm.anhtester.com/admin/authentication");

        //So sánh chứa
        boolean checkURL = url.contains("/admin/authentication");
        softAssert.assertTrue(checkURL, "URL không chứa giá trị mong muốn");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).submit();

        boolean checkMenuDashboard = driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).isDisplayed();
        softAssert.assertTrue(checkMenuDashboard);

        // Mở menu Project
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();

        softAssert.assertAll();
    }
}
