package TestCMS_System.pages;

import TestCMS_System.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuProducts = By.xpath("//span[normalize-space()='Products']");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By dropdownProfile = By.xpath("//span[@class='avatar avatar-sm mr-md-2']//img");
    private By optionLogout = By.xpath("//span[normalize-space()='Logout']");
    private By menuCategory = By.xpath("//span[normalize-space()='Category']");


    public void clickMenuProduct(){
        WebUI.clickElement(menuProducts);
        System.out.println("Click on menu Products");
    }

    public CategoryPage clickMenuCategory(){
        WebUI.clickElement(menuCategory);
        System.out.println("Click on menu Category");

        return new CategoryPage(driver);
    }

    public LoginPage logout(){
        WebUI.clickElement(dropdownProfile);
        System.out.println("Click on dropdown Profile");
        WebUI.clickElement(optionLogout);
        System.out.println("Click on option Logout");

        return new LoginPage(driver);
    }
}
