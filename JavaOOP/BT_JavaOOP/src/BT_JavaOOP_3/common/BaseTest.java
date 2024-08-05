package BT_JavaOOP_3.common;

public class BaseTest {

    public void createDriver(){
        System.out.println("Browser: " + Constants.browser); // cấu trúc của biến static
        System.out.println("Report: " + Constants.report);
        System.out.println("Headless: " + Constants.headless);

    }


    public void closeDriver(String browser){
        System.out.println("Closed browser: " + browser);
    }
}
