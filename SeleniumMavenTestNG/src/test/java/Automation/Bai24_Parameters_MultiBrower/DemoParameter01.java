package Automation.Bai24_Parameters_MultiBrower;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameter01 {
    @Test
    @Parameters({"number1","number2"})
    public void tinhtong2So(int a, int b){
        System.out.println("Tổng 2 số: "+ (a+b));

    }

    @Test
    @Parameters({"number1","number2","number3"})
    public void tinhtong3So(int a, int b, int c){
        System.out.println("Tổng 3 số: "+ (a+b+c));

    }

    @Test
    @Parameters({"email","password"})
    public void login(String email, String password){
        System.out.println(email + " - " + password);

    }
}
