package autotest.Bai7_WebDriver;

import autotest.Bai5_Locators.BT_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Demo_WebDriverBasic {
    public static void main(String[] args) throws InterruptedException {

        //Khởi tạo Browser
        WebDriver driver = new EdgeDriver();

        //2 hàm chờ đợi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Chờ đợi tối đa 1 trang load
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        //2 hàm để phóng to thu nhỏ trình duyệt
        driver.manage().window().maximize();

        //Mở 1 URL
        driver.navigate().to("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        //Get Title
        System.out.println("Title: "+ driver.getCurrentUrl());
        System.out.println("URL: " + driver.getTitle());

        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.navigate().forward();
        Thread.sleep(1000);


        
        //Đóng Browser
        driver.quit();
    }
}
