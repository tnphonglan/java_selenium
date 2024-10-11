package Automation.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoExplicitWait {

    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }

    @Test(priority = 1)
    public void testLoginHRM_Success() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://hrm.anhtester.com");
        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin_example");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Projects']")));
        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='collapsed btn waves-effect waves-light btn-primary btn-sm m-0']")));
        driver.findElement(By.xpath("//a[@class='collapsed btn waves-effect waves-light btn-primary btn-sm m-0']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='title']")));
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("selenium");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='budget_hours']")));
        driver.findElement(By.xpath("//input[@name='budget_hours']")).click();

        Thread.sleep(1000);


    }
}
