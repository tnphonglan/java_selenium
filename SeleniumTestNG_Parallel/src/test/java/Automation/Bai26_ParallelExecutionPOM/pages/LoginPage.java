package Automation.Bai26_ParallelExecutionPOM.pages;

import Automation.drivers.DriverManager;
import Automation.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {

    private String url = "https://crm.anhtester.com/admin/authentication";

    //Khai báo tất cả object (element) trên page này
    //Thuộc kiểu đối tượng By (thuộc của Selenium)
    By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By errorMessage = By.xpath("//div[@class='text-center alert alert-danger']");
    By menuDashboard = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Dashboard']");

    //Xây dựng các hàm xử lý trên chính page này
    private void setInputEmail(String email) {
        WebUI.setText(inputEmail, email);
    }

    private void setInputPassword(String password) {
        WebUI.setText(inputPassword, password);
    }

    private void clickButtonLogin() {
        WebUI.waitForElementVisible(buttonLogin);
        WebUI.clickElement(buttonLogin);
    }

    public DashboardPage loginCRM(String email, String password) {
        WebUI.openURL(url);
        WebUI.waitForPageLoaded();
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();
        WebUI.waitForPageLoaded();
        return new DashboardPage();
    }

    public void verifyLoginSuccess() {
        System.out.println("Verify Login Success");
        Assert.assertTrue(DriverManager.getDriver().findElement(menuDashboard).isDisplayed(), "Menu Dashboard not displayed.");
        Assert.assertEquals(WebUI.getElementText(menuDashboard), "Dashboard", "Content of Menu Dashboard not match.");
    }

    public void verifyLoginFail() {
        System.out.println("Verify Login Fail");
        Assert.assertTrue(DriverManager.getDriver().findElement(errorMessage).isDisplayed(), "Error message not displayed.");
        Assert.assertEquals(WebUI.getElementText(errorMessage), "Invalid email or password", "Content of error message not match.");
    }

    public void verifyRedirectLoginPage() {
        System.out.println("Verify Redirect Login Page");
        Assert.assertTrue(DriverManager.getDriver().findElement(headerLoginPage).isDisplayed(), "Header of Login page not displayed");
        Assert.assertEquals(WebUI.getElementText(headerLoginPage), "Login", "Content of header Login page not match.");
    }
}
