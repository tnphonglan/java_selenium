package tinhkethua;

public class Student extends Person {
    public String universityName;

    public Student(String name, int age, float height, String universityName) {
        super(name, age, height);//đảm bảo cấu trúc từ hàm xây dựng của class Person
        this.universityName = universityName;
    }

    //Ghi đè phương thức
    public void getInfo(){
        super.getInfo();
        System.out.println("University Name: "+universityName);
    }


    public static void main(String[] args) {
        Student student = new Student("Minh", 30, 1.56F, "KHXH và NV");
        student.getInfo();//Hàm getInfor này thuộc về class Student khôgn phải từ class Person
    }
}
