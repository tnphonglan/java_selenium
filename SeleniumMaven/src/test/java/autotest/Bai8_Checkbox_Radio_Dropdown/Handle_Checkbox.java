package autotest.Bai8_Checkbox_Radio_Dropdown;

import autotest.common.BaseTest;
import org.openqa.selenium.By;

import java.time.Duration;

public class Handle_Checkbox extends BaseTest {
    public static void main(String[] args) throws InterruptedException {

        createBrowser("chrome");

        driver.get("https://demoqa.com/checkbox");

        //Kiểm tra giá trị Default
        boolean checkCheckbox = driver.findElement(By.xpath("//input[@id='tree-node-home']")).isSelected();
        driver.findElement(By.xpath("//span[@class='rct-checkbox']")).click();
        boolean checkCheckboxAfter = driver.findElement(By.xpath("//input[@id='tree-node-home']")).isSelected();

        //driver.findElement(By.xpath("//button[@title='Expand all']//*[name()='svg']")).click();

        System.out.println("Checkbox Default: "+checkCheckbox);
        System.out.println("Checkbox Default After: "+checkCheckboxAfter);


        closeBrowser();
    }
}
