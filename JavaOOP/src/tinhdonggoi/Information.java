package tinhdonggoi;

public class Information {
    public static void main(String[] args) {
        Student student = new Student();

        student.setName("Hoa");
        student.setAge(25);
        student.setAddress("Hà Nội");
        student.setGender("Nữ");

        System.out.println("Name: "+student.getName());
        System.out.println("Age: "+student.getAge());
        System.out.println("Address: "+student.getAddress());
        System.out.println("Gender: "+student.getGender());


        Student student1 = new Student();
        student1.setName("Huyền");
        System.out.println("Name: " + student1.getName());
    }
}
