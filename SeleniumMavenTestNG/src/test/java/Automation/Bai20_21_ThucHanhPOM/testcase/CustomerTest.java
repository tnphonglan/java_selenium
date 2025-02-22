package Automation.Bai20_21_ThucHanhPOM.testcase;

import Automation.Bai20_21_ThucHanhPOM.pages.CustomerPage;
import Automation.Bai20_21_ThucHanhPOM.pages.DashboardPage;
import Automation.Bai20_21_ThucHanhPOM.pages.LoginPage;
import Automation.common.BaseTest;
import Automation.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    private String CUSTOMER_NAME = "Vietmap 01";

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage(driver);
        dashboardPage= loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customerPage = dashboardPage.clickMenuCustomer();

        customerPage.verifyRedirectCustomerPageSuccess();
        customerPage.clickButtonAddnew();
        customerPage.inputDataCustomer(CUSTOMER_NAME);

    }
}
