package tinhtruutuong;

public interface ReportManager {

    default void writeToRepor(){
        System.out.println("Set Driver");
    };
    void getDriver();
    public void closeDriver();

}
