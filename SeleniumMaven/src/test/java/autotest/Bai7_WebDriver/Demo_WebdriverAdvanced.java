package autotest.Bai7_WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Demo_WebdriverAdvanced {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        //2 hàm chờ đợi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Chờ đợi tối đa 1 trang load
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        //2 hàm để phóng to thu nhỏ trình duyệt
        driver.manage().window().maximize();
        driver.navigate().to("https:\\anhtester.com");
        Thread.sleep(1000);

        String window1 = driver.getWindowHandle();
        System.out.println("Mã Window 1: " + driver.getWindowHandle());

        //Mở tab mới và chuyển hướng đến Tab đó
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https:\\google.com");
        String window2 = driver.getWindowHandle();
        System.out.println("Mã Window 2: " + window2);
        Thread.sleep(1000);


        //Mở cửa số Window mới và chuyển hướng đến window đó
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https:\\github.com");
        System.out.println("Mã Window 3: " + driver.getWindowHandle());

        //Chuyển về cửa số chỉ định
        driver.switchTo().window(window1);
        Thread.sleep(2000);

        driver.switchTo().window(window2);
        Thread.sleep(2000);


        //Đóng Browser
        driver.quit();

    }
}
