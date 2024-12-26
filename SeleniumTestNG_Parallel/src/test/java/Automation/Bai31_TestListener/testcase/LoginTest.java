package Automation.Bai31_TestListener.testcase;

import Automation.Bai31_TestListener.pages.LoginPage;
import Automation.common.BaseTest;
import Automation.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //Khai báo 1 đối tượng class LoginPage toàn cục
    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success() {
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "LoginData");

        loginPage.loginCRM(
                excelHelper.getCellData("email", 1),
                excelHelper.getCellData("password", 1)
        );
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCRM_EmailInvalid() {
        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "LoginData");

        loginPage.loginCRM(
                excelHelper.getCellData("email", 2),
                excelHelper.getCellData("password", 2)
        );
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCRM_PasswordInvalid() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "12345678");
        loginPage.verifyLoginFail();
    }
}
