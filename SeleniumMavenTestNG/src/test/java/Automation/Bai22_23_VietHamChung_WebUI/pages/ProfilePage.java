package Automation.Bai22_23_VietHamChung_WebUI.pages;

import Automation.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProfilePage extends CustomerPage {

    private WebDriver driver;

    public ProfilePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    public void verifyCusromerDetail(String CompanyName){
        Assert.assertEquals(driver.findElement(inputCompany).getAttribute("value"),"Vietmap 01", "Message");
    }
}
