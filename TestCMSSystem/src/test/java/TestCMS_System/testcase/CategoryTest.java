package TestCMS_System.testcase;

import TestCMS_System.common.BaseTest;
import TestCMS_System.constants.ConfigData;
import TestCMS_System.pages.CategoryPage;
import TestCMS_System.pages.DashboardPage;
import TestCMS_System.pages.LoginPage;
import TestCMS_System.pages.ProductPage;
import org.openqa.selenium.devtools.v85.applicationcache.model.ApplicationCacheStatusUpdated;
import org.testng.annotations.Test;

public class CategoryTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ProductPage productPage;
    CategoryPage categoryPage;

    private String CATEGORY_NAME = "Vietmap 01";

    @Test
    public void testAddNewCategory(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.login(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        dashboardPage.clickMenuProduct();
        categoryPage = dashboardPage.clickMenuCategory();
        categoryPage.verifyRedirectCategorySuccess();
        categoryPage.clickButtonAddNewCatrgory();
        categoryPage.inputDataCategory(CATEGORY_NAME);


    }
}
