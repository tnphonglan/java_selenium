package Automation.Bai26_ParallelExecutionPOM.testcase;

import Automation.Bai26_ParallelExecutionPOM.pages.CustomerPage;
import Automation.Bai26_ParallelExecutionPOM.pages.DashboardPage;
import Automation.Bai26_ParallelExecutionPOM.pages.LoginPage;
import Automation.common.BaseTest;
import Automation.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    private String CUSTOMER_NAME = "Vietmap 04";

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customerPage = dashboardPage.clickMenuCustomer();

        customerPage.verifyRedirectCustomerPageSuccess();
        customerPage.clickButtonAddnew();
        customerPage.inputDataCustomer(CUSTOMER_NAME);

    }
}
