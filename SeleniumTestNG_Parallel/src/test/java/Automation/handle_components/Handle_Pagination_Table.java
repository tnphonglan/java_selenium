package Automation.handle_components;

import Automation.Bai31_TestListener.pages.CustomerPage;
import Automation.Bai31_TestListener.pages.DashboardPage;
import Automation.Bai31_TestListener.pages.LoginPage;
import Automation.common.BaseTest;
import Automation.constants.ConfigData;
import Automation.drivers.DriverManager;
import Automation.helpers.PropertiesHelper;
import Automation.keywords.WebUI;
import Automation.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Handle_Pagination_Table extends BaseTest {

    public void checkSearchTableByColumn(int column, String value) {

        //Xác định số dòng của table sau khi search
        List<WebElement> row = DriverManager.getDriver().findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("Số dòng tìm thấy: " + rowTotal);

        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = DriverManager.getDriver().findElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));

            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].scrollIntoView(false);", elementCheck);

            System.out.print(value + " - ");
            System.out.println(elementCheck.getText());
            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }
    }

    @Test
    public void testCheckPaginationOnTable() {

        WebUI.openURL("https://datatables.net/");

        //Data search read from Properties
        String searchValue = PropertiesHelper.getValue("searchValue");

        //Get item on One Page
        Select select = new Select(WebUI.getWebElement(By.xpath("//select[@name='example_length']")));

        LogUtils.info(select.getFirstSelectedOption().getText());

        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số item / trang: " + itemTotalOnePage);

        //Set Text on Search input
        WebUI.setText(By.xpath("//input[@type='search']"), searchValue);

        //Get total item
        String strTotal = WebUI.getElementText(By.xpath("//div[@id='example_info']"));
        ArrayList<String> list = new ArrayList<String>();

        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }

        System.out.println(list);

        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("Tổng số item: " + itemTotal);
        int pageTotal = itemTotal / itemTotalOnePage;
        int sodu = itemTotal % itemTotalOnePage;
        System.out.println("Tổng số nguyên: " + pageTotal);
        System.out.println("Tổng số dư: " + sodu);

        if (sodu > 0) {
            pageTotal = pageTotal + 1;
        }

        System.out.println("Tổng số Page: " + pageTotal);

        for (int i = 1; i <= pageTotal; i++) {
            checkSearchTableByColumn(3, searchValue);

            //Nhấn nút Next để đến trang tiếp theo
            if (i < pageTotal) {
                WebUI.clickElement(By.xpath("//a[@id='example_next']"));
            }
        }

    }

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testCheckDataOnTable_Pagination() {
        String searchValue = "A1";
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        customerPage = dashboardPage.clickMenuCustomer();

        //Get item on One Page
        Select select = new Select(WebUI.getWebElement(By.xpath("//select[@name='clients_length']")));

        select.selectByVisibleText("10");
        WebUI.sleep(1);

        LogUtils.info(select.getFirstSelectedOption().getText());

        int itemTotalOnePage = Integer.parseInt(select.getFirstSelectedOption().getText());
        System.out.println("Tổng số item / trang: " + itemTotalOnePage);

        //Set Text on Search input
        //WebUI.setText(By.xpath("//input[@type='search']"), searchValue);
        customerPage.searchCusromer2(searchValue); //Trả ra 26 items

        //Get total item
        String strTotal = WebUI.getElementText(By.xpath("//div[@id='clients_info']"));
        ArrayList<String> list = new ArrayList<String>();

        for (String strItem : strTotal.split("\\s")) {
            list.add(strItem);
        }

        System.out.println(list);

        int itemTotal = Integer.parseInt(list.get(5));
        System.out.println("Tổng số item: " + itemTotal);
        int pageTotal = itemTotal / itemTotalOnePage;
        int sodu = itemTotal % itemTotalOnePage;
        System.out.println("Tổng số nguyên: " + pageTotal);
        System.out.println("Tổng số dư: " + sodu);

        if (sodu > 0) {
            pageTotal = pageTotal + 1;
        }

        System.out.println("Tổng số Page: " + pageTotal);

        for (int i = 1; i <= pageTotal; i++) {
            checkSearchTableByColumn(3, searchValue);

            //Nhấn nút Next để đến trang tiếp theo
            if (i < pageTotal) {
                WebUI.clickElement(By.xpath("//a[normalize-space()='Next']"));
                WebUI.sleep(2);
            }
        }

    }
}

