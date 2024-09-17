package Automation.ThucHanh;

import Automation.common.BaseTest;
import Automation.common.BaseTestDependency;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ThucHanhAnnotationDependency extends BaseTestDependency {

    @Test
    public void testLoginCRM1(){
        System.out.println("LoginCRM1");
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).submit();
    }

    @Test
    public void testLoginCRM2(){
        System.out.println("LoginCRM2");
        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();
    }
}
