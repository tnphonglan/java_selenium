package BT_JavaOOP_3.testcases;

import BT_JavaOOP_3.common.BaseTest;

public class TestCase extends BaseTest {

    public  void loginCMS(){

        createDriver();
        System.out.println("Navigate to url: https://cms.anhtester.com/login");
        System.out.println("Enter email and password");
        System.out.println("Click Login button");
        System.out.println("Verify the message successfully is disable");
        closeDriver("Chrome");

    }

    public void addCategoryCMS(){

        createDriver();
        System.out.println("Navigate to url: https://cms.anhtester.com/login");
        System.out.println("Enter email and password");
        System.out.println("Click Login button");
        System.out.println("Verify the message successfully is disable");
    // Add new category
        System.out.println("Click on the Products menu");
        System.out.println("Click on the Category menu");
        System.out.println("Click Add New Category button");
        System.out.println("Enter data for all fields in form add category");
        System.out.println("Click Save button");
        System.out.println("Verify new category added");
        closeDriver("Chrome");
    }

    public static void main(String[] args) {
        TestCase testCase = new TestCase();
        testCase.loginCMS();
        System.out.println("************");
        testCase.addCategoryCMS();
    }
}
