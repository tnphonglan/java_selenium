package Automation.Bai20_21_ThucHanhPOM.pages;

import Automation.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerPage {
    private WebDriver driver;

    public CustomerPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By buttonAddNewCustomers = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImport = By.xpath("//a[normalize-space()='Import Customers']");
    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By inputSearch = By.xpath("//div[@id='clients_filter']//input[@type='search']");

    //Trang Customers List

    private By buttonImportCustomers = By.xpath("//a[normalize-space()='Import Customers']");
    private By buttonContacts = By.xpath("//a[contains(@href,'all_contacts')]");    //Cách 2: "//a[normalize-space()='Import Customers']/following-sibling::a[normalize-space()='Contacts']"
    private By buttonSearchCustomers = By.xpath("//div[@id='clients_filter']//input[@aria-controls='clients']");
    private By firstItemCustomerOnTable = By.xpath("//tr[@class='has-row-options odd']//td[@class='sorting_1']/a]");

    //Add new customers
    public By inputCompany = By.xpath("//input[@id='company']");
    public By inputVAT = By.xpath("//input[@id='vat']");
    public By inputPhone = By.xpath("//input[@id='phonenumber']");
    public By inputWebsite = By.xpath(" //input[@id='website']");
    private By dropdownGroups = By.xpath("//button[@data-id='groups_in[]']");
    private By inputSearchGroup = By.xpath("//div[@app-field-wrapper='groups_in[]']//input[@type='search']");
    private By dropdownCurrency = By.xpath("//button[@data-id='default_currency']");
    private By inputSearchCurrency = By.xpath("//div[@app-field-wrapper='default_currency']//input[@type='search']");
    private By dropdownLanguage = By.xpath("//button[@data-id='default_language']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("//div[@app-field-wrapper='country']//input");
    private By buttonSaveAndCreateContact = By.xpath("//button[normalize-space()='Save and create contact']");
    private By buttonSaveCustomer = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");

    public void clickButtonAddnew(){
        WebUI.clickElement(buttonAddNewCustomers);
    }

    public void verifyRedirectCustomerPageSuccess(){
        Assert.assertTrue(driver.findElement(headerCustomerPage).isDisplayed(), "Không tìm thấy Customer header page");
        Assert.assertEquals(driver.findElement(headerCustomerPage).getText(),"Customers Summary", "Giá trị header của Customer page không đúng");
    }

    public void inputDataCustomer(String CompanyName){
        WebUI.setText(inputCompany, CompanyName);
        WebUI.setText(inputVAT, "10");
        WebUI.setText(inputPhone, "123456");
        WebUI.setText(inputWebsite, "https://vietmap.vn/");
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputSearchGroup,"Gold");
        WebUI.sleep(1);
        driver.findElement(inputSearchGroup).sendKeys(Keys.ENTER);
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputAddress,"197 Trần Phú");
        WebUI.setText(inputCity,"HCM");
        WebUI.setText(inputState,"HCM");
        WebUI.setText(inputZipCode,"1234");
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry,"Vietnam");
        WebUI.sleep(1);
        driver.findElement(inputSearchCountry).sendKeys(Keys.ENTER);
        WebUI.clickElement(buttonSaveCustomer);
    }

    public ProfilePage searchCusromer(String CompanyName){
        WebUI.setText(buttonSearchCustomers, CompanyName);
        WebUI.sleep(2);
        WebUI.clickElement(firstItemCustomerOnTable);

        return new ProfilePage(driver);
    }

}
