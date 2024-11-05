package Automation.Bai22_23_VietHamChung_WebUI.pages;

import Automation.common.LocatorsCRM;
import Automation.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private String url = "https://crm.anhtester.com/admin/authentication";

    //Khai báo driver cục bộ trong chin class này
    private WebDriver driver;
    private WebDriverWait wait;

    //Hàm xây dựng để truyền driver từ bên ngoài vào (có thể từ BeTesst...)
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new WebUI(driver);

    }

    //Khai báo tất cả object (element) trên page này
    //Thuộc kiểu đối tượng By (thuộc của Selenium)
    By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By errorMessage = By.xpath("//div[@class='text-center alert alert-danger']");

    //Xây dựng các hàm xử lý trên chính page này
    private void setInputEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        //driver.findElement(inputEmail).sendKeys(email);
        //System.out.println("Set email: " + email);
        WebUI.setText(inputEmail, email);
    }

    private void setInputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        //driver.findElement(inputPassword).sendKeys(password);
       // System.out.println("Set password: " + password);
        WebUI.setText(inputPassword, password);
    }

    private void clickButtonLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        //driver.findElement(buttonLogin).click();
        //System.out.println("Click on Login button: " + buttonLogin);
        WebUI.clickElement(buttonLogin);
    }

    //public void loginCRM(String email, String password){
    //driver.get(url);
    //System.out.println("Navigate to URL: "+url);
    //setInputEmail(email);
    //setInputPassword(password);
    //clickButtonLogin();
//}

    public DashboardPage loginCRM(String email, String password){
        //driver.get(url);
        WebUI.openURL(url);
        //System.out.println("Navigate to URL: "+url);
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();

        return new DashboardPage(driver);
    }

    public void verifyLoginSuccess(){
        System.out.println("Verify Login Success");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.menuDashboard)).isDisplayed(),"Menu Dashboard not displayed.");

    }

    public void verifyLoginFail(){
        System.out.println("Verify Login Fail");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(),"Error message not displayed.");
        Assert.assertEquals(driver.findElement(errorMessage).getText(),"Invalid email or password", "Content of error message not match.");
    }

    public void verifyRedirectLoginPage(){
        System.out.println("Verify Redirect Login Page");
        Assert.assertTrue(driver.findElement(headerLoginPage).isDisplayed(),"Header of Login page not displayed");
        Assert.assertEquals(driver.findElement(headerLoginPage).getText(),"Login", "Content of header Login page not match.");
    }
}
