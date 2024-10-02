package Automation.common;

import Automation.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public static void sleep(double second){
        try {
            Thread.sleep((long) (1000*second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void createScreenCapture(String imageName) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //Get size screen browser
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        //Khởi tạo kích thước khung hình với kích cỡ trên
        Rectangle screenRectangle = new Rectangle(screenSize);
        //Tạo hình chụp với độ lớn khung đã tạo trên
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //Lưu hình vào dạng file với dạng png
        File file = new File(imageName + ".png");
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sleep(2);
    }

    @BeforeMethod
    public void  createBrowser(){
        //Khởi tạo Browser
        driver = new ChromeDriver();
        //2 hàm chờ đợi
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Chờ đợi tối đa 1 trang load
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        //2 hàm để phóng to thu nhỏ trình duyệt
        driver.manage().window().maximize();

        //Khai báo class WebUI để khởi tạo giá trị driver cho class WebUI
        new WebUI(driver); // kiểu khai báo anonymous (ẩn danh)
    }

    public void  createBrowser(String browserName){

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

    @AfterMethod
    public void closeBrowser (){
        //Đóng Browser
        driver.quit();
    }

}
