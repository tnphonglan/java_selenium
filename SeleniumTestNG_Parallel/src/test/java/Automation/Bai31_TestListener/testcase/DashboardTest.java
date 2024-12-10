package Automation.Bai31_TestListener.testcase;

import Automation.Bai31_TestListener.pages.CustomerPage;
import Automation.Bai31_TestListener.pages.DashboardPage;
import Automation.Bai31_TestListener.pages.LoginPage;
import Automation.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage() {
        customerPage.verifyRedirectCustomerPageSuccess();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomer();
        customerPage.verifyRedirectCustomerPageSuccess();

    }

    @Test
    public void testLogout() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        loginPage = dashboardPage.logout();
        loginPage.verifyRedirectLoginPage();

    }
}
