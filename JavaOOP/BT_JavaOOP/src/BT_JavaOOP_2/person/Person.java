package BT_JavaOOP_2.person;

public class Person {
    private String name;
    private int age;
    private String gender;
    private String address;
    private String phone;

public Person(String name, int age, String gender, String address, String phone){
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.address = address;
    this.phone = phone;
}

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    protected void getThongTinNhanVien(){
        System.out.println(getName());
        System.out.println(getAge());
        System.out.println(getPhone());
        System.out.println(getGender());
        System.out.println(getAddress());
    }

    public String getName(){
        return name;
    }
    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    protected String getAddress() {
        return address;
    }

    protected String getPhone() {
        return phone;
    }

}
