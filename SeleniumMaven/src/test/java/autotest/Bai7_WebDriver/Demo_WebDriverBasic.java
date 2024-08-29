package autotest.Bai7_WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Demo_WebDriverBasic {
    public static void main(String[] args) {

        //Khởi tạo Browser
        WebDriver driver = new ChromeDriver();

        //2 hàm chờ đợi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Chờ đợi tối đa 1 trang load
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }
}
