package Automation.Bai13_Alert_PopupWindown_iFrame;

import Automation.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DemoHandlePopupWindown extends BaseTest {

    @Test
    public void demoNotSwitchToTab() {
        driver.get("https://demoqa.com/browser-windows");
        sleep(2);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        sleep(1);
        //Sau khi chuyển hướng sang Tab mới thì getText cái header
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        sleep(1);
    }

    @Test
    public void testPopupWindown1(){
        //Cách 1: dùng vòng lặp for


    }

    @Test
    public void testPopupWindown2(){
        //Cách 2: dùng vị tró trong collect set (driver.getWindownHandles)


    }
}
