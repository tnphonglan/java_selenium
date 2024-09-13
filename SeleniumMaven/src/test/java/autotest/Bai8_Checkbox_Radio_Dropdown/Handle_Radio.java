package autotest.Bai8_Checkbox_Radio_Dropdown;

import autotest.common.BaseTest;
import org.openqa.selenium.By;

public class Handle_Radio extends BaseTest {
    public static void main(String[] args) {
        createBrowser("chrome");
        driver.get("https://demoqa.com/radio-button");

        //boolean checkRadioYes = driver.findElement(By.xpath("//input[@id='yesRadio']")).isSelected();
        //System.out.println("Radio Yes: " + checkRadioYes);

        driver.findElement(By.xpath("//div[@class='mb-3']/following-sibling::div//input[@id='yesRadio']")).click();
        //checkRadioYes = driver.findElement(By.xpath("//input[@id='yesRadio']")).isSelected();
        //System.out.println("Radio Yes After: " + checkRadioYes);

        closeBrowser();
    }
}
