package TestCMS_System.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTestCMS {

    public static WebDriver driver;

        @BeforeMethod
    public void  createBrowser(){
        //Khởi tạo Browser
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }

        @AfterMethod
    public void closeBrowser (){
        //Đóng Browser
        driver.quit();
    }
}
