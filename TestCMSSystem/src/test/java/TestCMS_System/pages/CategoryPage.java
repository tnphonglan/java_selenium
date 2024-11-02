package TestCMS_System.pages;

import TestCMS_System.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CategoryPage {

    private WebDriver driver;

    public CategoryPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    //Category list
    private By headerCategoryPage = By.xpath("//h1[normalize-space()='All categories']");
    private By buttonAddNewCategory = By.xpath("//span[normalize-space()='Add New category']");
    private By inputSearchCategory = By.xpath("//input[@id='search']");

    //Add new Category
    private By firstItemCategoryOnTable = By.xpath("//div[@class='card-body']/descendant::td[3]");
    private By inputNameCategory = By.xpath("//input[@id='name']");
    private By dropdownParentCategory = By.xpath("//div[contains(text(),'No Parent')]");
    private By inputSearchParentCategory = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By inputOrderingNumber = By.xpath("//input[@id='order_level']");
    private By dropdownCategoryType = By.xpath("//div[@class='dropdown bootstrap-select form-control aiz- mb-2 mb-md-0']");
    private By optionPhysical = By.xpath("//span[normalize-space()='Physical']");
    private By optionDigital = By.xpath("//span[normalize-space()='Digital']");
    private By inputBanner = By.xpath("//label[contains(text(),'Banner')]/following-sibling::div//div[contains(text(),'Browse')]");
    private By inputIcon = By.xpath("//label[contains(text(),'Icon')]/following-sibling::div//div[contains(text(),'Browse')]");
    private By inputMetaTitle = By.xpath("//label[normalize-space()='Meta Title']/following-sibling::div//input");
    private By inputMetaDescription = By.xpath("//textarea[@name='meta_description']");
    private By dropdownFilteringAttributes = By.xpath("//button[@title='Nothing selected']");
    private By inputSearchFilteringAttributes = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");
    private By inputSearchImageFile = By.xpath("//div[@id='aiz-select-file']//input[@name='aiz-uploader-search']");
    private By buttonSaveCategory = By.xpath("//button[normalize-space()='Save']");
    private By inputSearchImage = By.xpath("//input[@placeholder='Search your files']");
    private By firstItemSelectFile = By.xpath("//div[@id='aiz-select-file']/descendant::div[@class = 'card card-file aiz-uploader-select'][1]");
    private By buttonAddFiles = By.xpath("//button[normalize-space()='Add Files']");

    public void clickButtonAddNewCatrgory(){
        WebUI.clickElement(buttonAddNewCategory);
        WebUI.sleep(2);
    }

    public void verifyRedirectCategorySuccess(){
        Assert.assertTrue(driver.findElement(headerCategoryPage).isDisplayed(), "Không tìm thấy Category header page");
        Assert.assertEquals(driver.findElement(headerCategoryPage).getText(),"All categories", "Giá trị header của Category page không đúng");
    }

    public void inputDataCategory(String CategoryName){
        WebUI.setText(inputNameCategory, CategoryName);
        WebUI.clickElement(dropdownParentCategory);
        WebUI.sleep(1);
        WebUI.setText(inputSearchParentCategory,"aka");
        driver.findElement(inputSearchParentCategory).sendKeys(Keys.ENTER);
        WebUI.setText(inputOrderingNumber,"123");
        WebUI.clickElement(dropdownCategoryType);
        WebUI.clickElement(optionDigital);
        WebUI.clickElement(inputBanner);
        WebUI.sleep(3);
        WebUI.setText(inputSearchImageFile,"icon_ford1");
        WebUI.sleep(3);
        WebUI.clickElement(firstItemSelectFile);
        WebUI.sleep(3);
        WebUI.clickElement(buttonAddFiles);
        WebUI.sleep(3);
    }


}
