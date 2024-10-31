package Automation.Bai19_NavigationPage.pages;

import Automation.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerPage {
    private WebDriver driver;

    public CustomerPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By buttonAddNew = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImport = By.xpath("//a[normalize-space()='Import Customers']");
    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By inputSearch = By.xpath("//div[@id='clients_filter']//input[@type='search']");

    public void clickButtonAddnew(){
        WebUI.clickElement(buttonAddNew);
    }

    public void verifyRedirectCustomerPageSuccess(){
        Assert.assertTrue(driver.findElement(headerCustomerPage).isDisplayed(), "Không tìm thấy Customer header page");
        Assert.assertEquals(driver.findElement(headerCustomerPage).getText(),"Customers Summary", "Giá trị header page không đúng");
    }
}
