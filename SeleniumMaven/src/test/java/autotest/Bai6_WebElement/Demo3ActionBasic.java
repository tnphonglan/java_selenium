package autotest.Bai6_WebElement;

import autotest.Bai5_Locators.BT_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Demo3ActionBasic {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver(); //Khởi tạo 1 browser, để mở 1 trang web
        driver.manage().window().maximize(); //câu lệnh config để mở browser hết cỡ
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //để chờ đợi phần tử tối đa 10s

        driver.get("https://crm.anhtester.com/admin/authentication"); //Truy cập vào 1 trang web

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();

        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).submit();


        //driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        Thread.sleep(2000); //ngưng 2s trước khi tắt browser
        driver.quit(); //tắt browser
    }
}
