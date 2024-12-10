package Automation.common;

import Automation.drivers.DriverManager;
import Automation.helpers.CaptureHelper;
import Automation.helpers.PropertiesHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser(@Optional("chrome") String browserName) {
        //WebDriver driver = setBrowser(browserName);

        PropertiesHelper.loadAllFiles();
        WebDriver driver = setBrowser(PropertiesHelper.getValue("browser"));

        DriverManager.setDriver(driver); //gán giá trị driver vào trong ThreadLocal
    }

    public WebDriver setBrowser(String browserName) {
        WebDriver driver = null;

        //Khởi tạo Browser
        if (browserName.trim().toLowerCase().equals("chrome")) {
            driver = new ChromeDriver();
        }
        if (browserName.trim().toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
        }
        if (browserName.trim().toLowerCase().equals("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closeBrowser(ITestResult iTestResult) {

        //Chụp màn hình khi test case bị Fail, Pass không chụp
        if (ITestResult.FAILURE == iTestResult.getStatus()) {
            CaptureHelper.takeScreenshot(iTestResult.getName());
        }
        //Stop record video
        CaptureHelper.stopRecord();

        DriverManager.quit();
    }
}
