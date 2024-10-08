package objectclass;

public class SinhVien{
    String name;
    int age;
    String address;
    String className;

    //hàm xây dựng không tham số
    public SinhVien(){
        name = "Phuong";
        age = 32;
        address = "Hà Nội";
        className = "Java Basic";
    }

    //hàm xây dựng có tham số
    public SinhVien(String name, int age, String address, String className){
        this.name = name;
        this.age = age;
        this.address = address;
        this.className = className;
    }

    //các hàm truy xuất thông tin
    public String getName(){
        return name;

    }
    public String getClassName(){
        return className;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
    public void printInfo(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(address);
        System.out.println(className);
    }
}
