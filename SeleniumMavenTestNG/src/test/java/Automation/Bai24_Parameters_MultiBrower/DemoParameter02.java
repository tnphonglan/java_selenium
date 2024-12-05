package Automation.Bai24_Parameters_MultiBrower;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameter02 {

    @Test
    @Parameters({"number1","number2"})
    public void tinhtong2So(int a, int b){
        System.out.println("Tổng 2 số: "+ (a+b));

    }
}
