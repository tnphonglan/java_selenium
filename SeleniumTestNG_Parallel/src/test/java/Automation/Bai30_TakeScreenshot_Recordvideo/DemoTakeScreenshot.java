package Automation.Bai30_TakeScreenshot_Recordvideo;

import Automation.Bai26_ParallelExecutionPOM.pages.LoginPage;
import Automation.common.BaseTest;
import Automation.helpers.CaptureHelper;
import Automation.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DemoTakeScreenshot extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success() {
        System.out.println("=====testLoginCRM_Success=====");
        CaptureHelper.startRecord("testLoginCRM_Success");

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
    public void testLoginCRM_Fail() {
        System.out.println("=====testLoginCRM_Fail=====");
        CaptureHelper.startRecord("testLoginCRM_Fail");

        loginPage = new LoginPage();

        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/LoginData.xlsx", "LoginData");

        loginPage.loginCRM(
                excelHelper.getCellData("email", 2),
                excelHelper.getCellData("password", 2)
        );

        loginPage.verifyLoginSuccess();
    }
}

