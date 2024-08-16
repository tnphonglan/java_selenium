package autotest.Bai5_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginCMS {
    public static void main(String[] args) throws InterruptedException {

        //cấu trúc khở tạo Browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở 1 website CMS lên
        driver.get("https://cms.anhtester.com/login");

        //Định vị vị trí các element trên trang login CMS

        //1. Ô email
        driver.findElement(By.id("email")).sendKeys("admin@example.com");

        //2. Ô password
        driver.findElement(By.name("password")).sendKeys("123456");

        //3. Nút login
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000); //Chờ đợi 2 giây

        //tắt Browser
        driver.quit();
    }
}
