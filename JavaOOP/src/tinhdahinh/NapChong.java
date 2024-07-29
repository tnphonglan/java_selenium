package tinhdahinh;

public class NapChong {

    //Khai báo nhiều hàm tên giống nhau nhưng kha nhau về tham Số

    public void getInfo(){
        System.out.println("Hàm getInfo không có tham số");
    }

    public void getInfo(String name){
        System.out.println("Name: "+ name);
        System.out.println("Address: Hà Nội");
    }

    public void getInfo(String name, String address){
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
    }

    public void login(String url, String email, String password){
        //Login bình thương
    }

    public void login(String url, String email, String password, String role){
        //Kiểm tra account đó thuộc role nào
    }

    public void login(String url, String email, String password, String role, String message){
        //Kiểm tra account đó thuộc role nào
        //Kiểm tra text của message sau khi login (message của pass và fail)
    }

    public static void main(String[] args) {
        NapChong napChong = new NapChong();
        napChong.getInfo("Anh Tester", "Cần Thơ");
    }

}
