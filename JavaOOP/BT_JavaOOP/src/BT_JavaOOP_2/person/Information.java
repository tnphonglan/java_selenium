package BT_JavaOOP_2.person;

public class Information {
    public static void main(String[] args) {
        Person person1 = new Person("Lan",33, "Nữ", "HCM", "0977469144");
        Person person2 = new Person("Minh",33, "Nam", "HN", "0977548976");


        person1.getThongTinNhanVien();
        System.out.println("******************");
        person2.getThongTinNhanVien();
    }
}
