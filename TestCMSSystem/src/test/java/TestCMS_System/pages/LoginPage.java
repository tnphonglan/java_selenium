package TestCMS_System.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private String url = "https://cms.anhtester.com/login";

    //Khai báo driver cục bộ trong chin class này
    private WebDriver driver;
    private WebDriverWait wait;

    //Hàm xây dựng để truyền driver từ bên ngoài vào (có thể từ BaseTest...)
    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    //Khai báo tất cả object (element) trên page này
    //Thuộc kiểu đối tượng By (thuộc của Selenium)
    By headerLoginPageCMS = By.xpath("//h1[normalize-space()='Welcome to Active eCommerce CMS']");
    By inputEmailCMS = By.xpath("//input[@id='email']");
    By inputPasswordCMS = By.xpath("//input[@id='password']");
    By buttonLoginCMS = By.xpath("//button[normalize-space()='Login']");
    By errorMessageCMS = By.xpath("//span[@data-notify='message']");

    //Xây dựng các hàm xử lý trên chính page này
    private void setInputEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmailCMS));
        driver.findElement(inputEmailCMS).sendKeys(email);
        System.out.println("Set email: "+email);
    }
    private void setInputPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPasswordCMS));
        driver.findElement(inputPasswordCMS).sendKeys(password);
        System.out.println("Set password: "+password);
    }

    private void clickButtonLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLoginCMS));
        driver.findElement(buttonLoginCMS).click();
        System.out.println("Click on Login button: "+buttonLoginCMS);
    }

    public DashboardPage login(String email, String password) {
        driver.get(url);
        System.out.println("Navigate to URL: "+url);
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();

        return new DashboardPage(driver);
    }

    public void verifyLoginSuccess(){
        System.out.println("Verify Login Success");
        Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Dashboard']")).isDisplayed(),"Menu Dashboard not displayed.");

    }

    public void verifyLoginFail(){
        System.out.println("Verify Login Fail");
        Assert.assertTrue(driver.findElement(errorMessageCMS).isDisplayed(),"Error message not displayed.");
        Assert.assertEquals(driver.findElement(errorMessageCMS).getText(),"Invalid login credentials", "Content of error message not match.");
    }
}
