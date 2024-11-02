package Automation.Bai20_21_ThucHanhPOM.pages;

import Automation.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By menuDashboard = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Dashboard']");
    private By menuCustomer = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Customers']");
    private By menuProject = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Projects']");
    private By dropdownProfile = By.xpath("//li[@class='icon header-user-profile']");
    private By optionLogout = By.xpath("//a[.='Logout']");
    private By menuProfile = By.xpath("//a[.='My Profile']");

    public CustomerPage clickMenuCustomer(){
        WebUI.clickElement(menuCustomer);
        System.out.println("Click on menu Customer");
        return new CustomerPage(driver);
    }

    public void clickMenuProject(){
        WebUI.clickElement(menuProject);
        System.out.println("Click on menu Project");
    }

    public LoginPage logout(){
        WebUI.clickElement(dropdownProfile);
        System.out.println("Click on dropdown Profile");
        WebUI.clickElement(optionLogout);
        System.out.println("Click on option Logout");

        return new LoginPage(driver);
    }
}
