package Automation.Bai22_23_VietHamChung_WebUI.testcase;

import Automation.Bai22_23_VietHamChung_WebUI.pages.CustomerPage;
import Automation.Bai22_23_VietHamChung_WebUI.pages.DashboardPage;
import Automation.Bai22_23_VietHamChung_WebUI.pages.LoginPage;
import Automation.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    @Test
    public void testOpenCustomerPage(){
//        loginPage = new LoginPage(driver);
//        loginPage.loginCRM("admin@example.com","123456");
//        loginPage.verifyLoginSuccess();
//        dashboardPage = new DashboardPage(driver);
//        dashboardPage.clickMenuCustomer();
//        customerPage = new CustomerPage(driver);
//        customerPage.verifyRedirectCustomerPageSuccess();

        loginPage = new LoginPage(driver);
        dashboardPage= loginPage.loginCRM("admin@example.com","123456");
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomer();
        customerPage.verifyRedirectCustomerPageSuccess();

    }

    @Test
    public void testLogout(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com","123456");
        loginPage.verifyLoginSuccess();
        loginPage = dashboardPage.logout();
        loginPage.verifyRedirectLoginPage();

    }
}
