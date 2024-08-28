package autotest.Bai6_WebElement;

import autotest.Bai5_Locators.BT_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Dem03ActionCheck {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver(); //Khởi tạo 1 browser, để mở 1 trang web
        driver.manage().window().maximize(); //câu lệnh config để mở browser hết cỡ
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //để chờ đợi phần tử tối đa 10s

        driver.get("https://anhtester.com/"); //Truy cập vào 1 trang web

        boolean checkDisplay = driver.findElement(By.xpath("//h1[normalize-space()='Anh Tester Automation Testing']")).isDisplayed();
        System.out.println("Check isDisplayed():" + checkDisplay);
        Thread.sleep(2000);

        driver.get("https://angular-reactive-forms-zvzqvd.stackblitz.io/");
        driver.findElement(By.xpath("//button[@onclick='__runProject()']")).click();
        boolean checkEnable1 = driver.findElement(By.xpath("//button[normalize-space()='Submit']")).isEnabled();
        System.out.println("Check isEnabled():" + checkEnable1);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        boolean checkEnable2 = driver.findElement(By.xpath("//button[normalize-space()='Submit']")).isEnabled();
        System.out.println("Check isEnabled():" + checkEnable2);
        Thread.sleep(2000);

        driver.get("https://crm.anhtester.com/admin/authentication");
        boolean checkSelected = driver.findElement(By.xpath(LocatorsCRM.checkboxRememberMe)).isSelected();
        System.out.println("Check isSelected():" + checkSelected);

        driver.findElement(By.xpath(LocatorsCRM.checkboxRememberMe)).click();
        boolean checkSelected2 = driver.findElement(By.xpath(LocatorsCRM.checkboxRememberMe)).isSelected();
        System.out.println("Check isSelected():" + checkSelected2);



        Thread.sleep(2000); //ngưng 2s trước khi tắt browser
        driver.quit(); //tắt browser
    }

}
