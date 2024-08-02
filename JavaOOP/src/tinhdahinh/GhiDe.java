package tinhdahinh;

public class GhiDe extends Acction{
    //Xảy ra kế thừa class cha và class con
    //Hàm của class con giống với tên hàm của class cha


    public void clickElement() {
        System.out.println("click on button Login");
    }

    public void login(){
        System.out.println("https://anhtester.com");
        System.out.println("Email: abc@gmail.com");
        System.out.println("password: 123456");
        clickElement();
    }

    public static void main(String[] args) {
        GhiDe ghiDe = new GhiDe();
        ghiDe.login();
    }
}
