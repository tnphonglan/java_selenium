package Automation.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProvider {
    //Khai báo nơi cung cấp dưc liệu - dùng @DataProvider
    @DataProvider(name = "dataLogin")
    public Object[][] dataLogin() {
        return new Object[][]{
                {"admin3@example.com", "123456", "tc1"},
                {"admin1@example.com", "1234567", "tc2"},
                {"admin2@example.com", "12345678", "tc3"}
        };
    }

    //Truyền nơi cung cấp dữ liệu vào trong test case @Test
    @Test(dataProvider = "dataLogin")
    public void testLoginSuccess(String email, String password, String message) {
        System.out.println("EMAIL: " + email);
        System.out.println("PASSWORD: " + password);
        System.out.println("MESSAGE: " + message);
    }
}
