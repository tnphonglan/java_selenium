package Automation.Bai26_ParallelExecutionPOM.testcase;

import Automation.Bai26_ParallelExecutionPOM.pages.LoginPage;
import Automation.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //Khai báo 1 đối tượng class LoginPage toàn cục
    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success() {
        System.out.println("=====testLoginCRM_Success=====");
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCRM_EmailInvalid() {
        System.out.println("=====testLoginCRM_EmailInvalid=====");
        loginPage = new LoginPage();
        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCRM_PasswordInvalid() {
        System.out.println("=====testLoginCRM_PasswordInvalid=====");
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "12345678");
        loginPage.verifyLoginFail();

    }
}
