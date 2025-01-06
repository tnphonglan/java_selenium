package Automation.Bai31_TestListener.pages;

import Automation.drivers.DriverManager;
import Automation.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CustomerPage {

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
    private By pageTotal = By.xpath("//div[@id='clients_info']");

    public void clickButtonAddnew() {
        WebUI.clickElement(buttonAddNewCustomers);
    }

    public void verifyRedirectCustomerPageSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerCustomerPage).isDisplayed(), "Không tìm thấy Customer header page");
        //Assert.assertEquals(WebUI.getElementText(headerCustomerPage),"Customers Summary", "Giá trị header của Customer page không đúng");
        WebUI.assertContains(WebUI.getElementText(headerCustomerPage), "Customers Summary", "Giá trị header của Customer page không đúng");
    }

    public void inputDataCustomer(String CompanyName) {
        WebUI.setText(inputCompany, CompanyName);
        WebUI.setText(inputVAT, "10");
        WebUI.setText(inputPhone, "123456");
        WebUI.setText(inputWebsite, "https://vietmap.vn/");
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputSearchGroup, "Gold");
        WebUI.sleep(1);
        WebUI.setKey(dropdownGroups, Keys.ENTER);
        //driver.findElement(inputSearchGroup).sendKeys(Keys.ENTER);
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(inputAddress, "197 Trần Phú");
        WebUI.setText(inputCity, "HCM");
        WebUI.setText(inputState, "HCM");
        WebUI.setText(inputZipCode, "1234");
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(inputSearchCountry, "Vietnam");
        WebUI.sleep(1);
        WebUI.setKey(dropdownCountry, Keys.ENTER);
        //driver.findElement(inputSearchCountry).sendKeys(Keys.ENTER);
        WebUI.clickElement(buttonSaveCustomer);
    }

    public ProfilePage searchCusromer(String CompanyName) {
        WebUI.setText(buttonSearchCustomers, CompanyName);
        WebUI.sleep(2);
        WebUI.clickElement(firstItemCustomerOnTable);
        return new ProfilePage();
    }

    public void searchCusromer2(String CompanyName) {
        WebUI.setText(buttonSearchCustomers, CompanyName);
        WebUI.sleep(2);
        WebUI.waitForPageLoaded();
    }

    public void checkPageTotal(int total) {
        String pageTotalText = WebUI.getElementText(pageTotal);
        System.out.println(pageTotalText);
        //Showing 1 to 4 of 4 entries (filtered from 283 total entries)
        String pageTotalNumber = pageTotalText.split(" ")[3];
        System.out.println("Check Page Total: " + pageTotalNumber);

        Assert.assertEquals(Integer.parseInt(pageTotalNumber), total, "The page not match.");
    }

    public void checkSearchTableByColumn(int column, String value) {

        //Xác định số dòng của table sau khi search
        List<WebElement> row = DriverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("Số dòng tìm thấy: " + rowTotal);

        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = DriverManager.getDriver().findElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));

            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(false);", elementCheck);

            System.out.print(value + " - ");
            System.out.println(elementCheck.getText());
            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }

    }
}
