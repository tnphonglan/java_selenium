package Automation.Bai26_ParallelExecutionPOM.pages;

import Automation.drivers.DriverManager;
import org.testng.Assert;

public class ProfilePage extends CustomerPage {

    public void verifyCusromerDetail(String CompanyName) {
        Assert.assertEquals(DriverManager.getDriver().findElement(inputCompany).getAttribute("value"), "Vietmap 01", "Message");
    }
}
