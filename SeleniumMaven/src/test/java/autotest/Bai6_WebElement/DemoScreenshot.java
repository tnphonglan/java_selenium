package autotest.Bai6_WebElement;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class DemoScreenshot {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver(); //Khởi tạo 1 browser, để mở 1 trang web
        driver.manage().window().maximize(); //câu lệnh config để mở browser hết cỡ
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //để chờ đợi phần tử tối đa 10s

        driver.get("https://anhtester.com");

        //Chụp hình phần tử chỉ định
        WebElement logo = driver.findElement(By.xpath("//body//section[@class='slider-area']//div[@class='row']//div[@class='row']//div[1]//div[1]//a[1]"));
        File file = logo.getScreenshotAs(OutputType.FILE);
        File destFile = new File("Website testing.png");
        try {
            Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Chụp cả màn hình
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(source, new File("full Screen.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Thread.sleep(2000);
        driver.quit();
    }
}
