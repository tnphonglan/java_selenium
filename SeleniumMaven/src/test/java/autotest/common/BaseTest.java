package autotest.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static void  createBrowser(){
        //Khởi tạo Browser
        driver = new EdgeDriver();
        //2 hàm chờ đợi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Chờ đợi tối đa 1 trang load
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        //2 hàm để phóng to thu nhỏ trình duyệt
        driver.manage().window().maximize();
    }

    public static void  createBrowser(String browserName){

        //Khởi tạo Browser
        if (browserName.trim().equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        if (browserName.trim().equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        if (browserName.trim().equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }

        //2 hàm chờ đợi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        //2 hàm để phóng to thu nhỏ trình duyệt
        driver.manage().window().maximize();
    }

    public static void closeBrowser (){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Đóng Browser
        driver.quit();
    }
}
