package Automation.handle_components;

import Automation.Bai31_TestListener.pages.CustomerPage;
import Automation.Bai31_TestListener.pages.DashboardPage;
import Automation.Bai31_TestListener.pages.LoginPage;
import Automation.common.BaseTest;
import Automation.constants.ConfigData;
import org.testng.annotations.Test;

public class Handle_Table_CustomerCRM extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testCheckDataOnTable() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        customerPage = dashboardPage.clickMenuCustomer();
        customerPage.searchCusromer2("Viettel A1");
        customerPage.checkPageTotal(5);
        customerPage.checkSearchTableByColumn(8, "Viettel A1");
    }
}
