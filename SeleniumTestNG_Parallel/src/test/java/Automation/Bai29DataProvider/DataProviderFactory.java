package Automation.Bai29DataProvider;

import Automation.helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    //Khai báo nơi cung cấp dưc liệu - dùng @DataProvider
    @DataProvider(name = "dataLogin", parallel = true)
    public Object[][] dataLogin() {
        return new Object[][]{
                {"admin3@example.com", "123456", "tc1"},
                {"admin1@example.com", "1234567", "tc2"},
                {"admin2@example.com", "12345678", "tc3"}
        };
    }

    @DataProvider(name = "dataAddCustomer", parallel = true)
    public Object[][] dataAddCustomer() {
        return new Object[][]{
                {"Hùng", 25, "Hà Nội"},
                {"Phương", 32, "Hà Nội"},
                {"Diệu", 36, "Hồ Chí Minh"}
        };
    }

    @DataProvider(name = "dataLoginFromExcel", parallel = true)
    public Object[][] dataLoginFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/testdata/LoginData.xlsx", "LoginData");

        System.out.println("Extract data from excel file:" + data);
        return data;
    }

    @DataProvider(name = "dataLoginFromExcelMultipleRow", parallel = true)
    public Object[][] dataLoginFromExcelMultipleRow() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable("src/test/resources/testdata/LoginData.xlsx", "LoginData", 2, 3);

        System.out.println("Extract data from excel file:" + data);
        return data;
    }
}
