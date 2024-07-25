package BT_JavaOOP_2.person;

public class Information {
    public static void main(String[] args) {
        Person person = new Person("Lan",33, "Nữ", "HCM", "0977469144");
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getGender());
        System.out.println(person.getAddress());
        System.out.println(person.getPhone());
    }
}
