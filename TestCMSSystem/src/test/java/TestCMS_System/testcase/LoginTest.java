package TestCMS_System.testcase;

import TestCMS_System.common.BaseTest;
import TestCMS_System.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //Khai báo 1 đối tượng class LoginPage toàn cục
    LoginPage loginPage;

    @Test
    public void testLogin_Success(){
        System.out.println("=====testLoginCRM_Success=====");
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCRM_EmailInvalid(){
        System.out.println("=====testLoginCMS_EmailInvalid=====");
        loginPage = new LoginPage(driver);
        loginPage.login("admin123@example.com", "123456");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCRM_PasswordInvalid(){
        System.out.println("=====testLoginCMS_PasswordInvalid=====");
        loginPage = new LoginPage(driver);
        loginPage.login("admin@example.com", "12345678");
        loginPage.verifyLoginFail();

    }
}
