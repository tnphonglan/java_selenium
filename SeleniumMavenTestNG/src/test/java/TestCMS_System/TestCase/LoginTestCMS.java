package TestCMS_System.TestCase;

import TestCMS_System.Common.BaseTestCMS;
import TestCMS_System.Pages.LoginPageCMS;
import org.testng.annotations.Test;

public class LoginTestCMS extends BaseTestCMS {

    //Khai báo 1 đối tượng class LoginPage toàn cục
    LoginPageCMS loginPageCMS;

    @Test
    public void testLoginCMS_Success(){
        System.out.println("=====testLoginCRM_Success=====");
        loginPageCMS = new LoginPageCMS(driver);
        loginPageCMS.loginCMS("admin@example.com", "123456");
        loginPageCMS.verifyLoginSuccess_CMS();
    }

    @Test
    public void testLoginCRM_EmailInvalid(){
        System.out.println("=====testLoginCMS_EmailInvalid=====");
        loginPageCMS = new LoginPageCMS(driver);
        loginPageCMS.loginCMS("admin123@example.com", "123456");
        loginPageCMS.verifyLoginFail_CMS();
    }

    @Test
    public void testLoginCRM_PasswordInvalid(){
        System.out.println("=====testLoginCMS_PasswordInvalid=====");
        loginPageCMS = new LoginPageCMS(driver);
        loginPageCMS.loginCMS("admin@example.com", "12345678");
        loginPageCMS.verifyLoginFail_CMS();

    }
}
