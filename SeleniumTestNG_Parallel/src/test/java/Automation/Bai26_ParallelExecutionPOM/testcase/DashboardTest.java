package Automation.Bai26_ParallelExecutionPOM.testcase;

import Automation.Bai26_ParallelExecutionPOM.pages.CustomerPage;
import Automation.Bai26_ParallelExecutionPOM.pages.DashboardPage;
import Automation.Bai26_ParallelExecutionPOM.pages.LoginPage;
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
