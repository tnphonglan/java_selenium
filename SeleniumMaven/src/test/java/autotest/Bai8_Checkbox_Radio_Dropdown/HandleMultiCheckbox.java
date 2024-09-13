package autotest.Bai8_Checkbox_Radio_Dropdown;

import autotest.common.BaseTest;
import org.openqa.selenium.By;

public class HandleMultiCheckbox extends BaseTest {
    public static void main(String[] args) {
        createBrowser("chrome");

        driver.get("https://demoqa.com/checkbox");
        driver.findElements(By.xpath(""));


        closeBrowser();
    }
}
