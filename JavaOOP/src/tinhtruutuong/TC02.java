package tinhtruutuong;

public class TC02 implements DriverManager, ReportManager{

    @Override
    public void setDriver() {
        System.out.println("Set Chorme Broser");
    }

    @Override
    public void writeToRepor() {
        ReportManager.super.writeToRepor();
    }

    @Override
    public void getDriver() {

    }

    @Override
    public void closeDriver() {

    }
}
