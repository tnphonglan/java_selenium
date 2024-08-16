package autotest.Bai5_Locators.XpathTuyetdoi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AddCategoryXpathTuyetDoi {

    public static void main(String[] args) throws InterruptedException {

        //Login CMS
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(2000); //Chờ đợi 2 giây



        //Open Category Page
        //Click Products menu
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/ul[2]/li[2]/a/span[1]")).click();

        //Click Category menu
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/ul[2]/li[2]/ul/li[8]/a/span")).click();

        //Open Add category
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[2]/a")).click();


        List<WebElement> elementList = driver.findElements(By.xpath("//ul[@id='main-menu']//li"));
        System.out.println("Số lượng menu: " + elementList.size());
        for (WebElement element : elementList){
            System.out.println("Tên menu: " + element.getText());
        }

        Thread.sleep(5000);

        driver.quit();
    }
}
