package autotest.Bai7_WebDriver;

import autotest.Bai5_Locators.BT_Locators.LocatorsCRM;
import autotest.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Demo_Cookies extends BaseTest {
    public static void main(String[] args) {
        createBrowser("chrome");

        //Mở 1 URL
        driver.navigate().to("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        //get Cookie By Name
        System.out.println("SP_Session:" + driver.manage().getCookieNamed("sp_sesion"));

        //Get All Cookies
        System.out.println("All Cookies:" + driver.manage().getCookies());

        Set<Cookie> allCookies = driver.manage().getCookies();

        for (Cookie cookie : driver.manage().getCookies()){
            System.out.println(cookie.getValue());
        }


        closeBrowser();
    }

}
