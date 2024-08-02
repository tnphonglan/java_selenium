package tinhtruutuong;

public class TestCase implements DriverManager, ReportManager{

    @Override
    public void setDriver() {
        System.out.println("Set Firefox Broser");
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
