package Automation.handle_components;

import Automation.common.BaseTest;
import Automation.helpers.SystemHelper;
import Automation.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class HandleUploadFile extends BaseTest {

    @Test
    public void testUploadFileWithSendKeys() {
        WebUI.openURL("https://the-internet.herokuapp.com/upload");

        WebUI.sleep(2);

        By inputFileUpload = By.xpath("//input[@id='file-upload']");

        WebUI.setText(inputFileUpload, SystemHelper.getCurrentDir() + "src\\test\\resources\\testdata/Vinfast.png");

        WebUI.sleep(3);
    }

    @Test
    public void testUploadFileWithRobossClass() {
        WebUI.openURL("https://files.fm/");

        WebUI.sleep(2);

        By textOnPage = By.xpath("//div[@id='file_select_dragndrop_text']");
        By divFileUpload = By.xpath("//div[@id='uploadifive-file_upload']");
        By inputFileUpload = By.xpath("//div[@id='file_select_button']//input[@id='file_upload']");

        String filePath = SystemHelper.getCurrentDir() + "src\\test\\resources\\testdata\\Vinfast1.png";

        //Click để mở form upload
        WebUI.clickElement(divFileUpload);
        WebUI.sleep(3);

        // Khởi tạo Robot class
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Copy File path vào Clipboard
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        WebUI.sleep(1);

        // Nhấn Control+V để dán
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // Xác nhận Control V trên
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        WebUI.sleep(2);

        // Nhấn Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        WebUI.sleep(4);

        By fileName = By.xpath("//span[@class = 'filename']");
        Assert.assertTrue(WebUI.checkElementExist(fileName), "The file can not upload");
    }
}
