package tinhkethua;

public class Employee extends Person{
    public Employee(String name, int age, float height){
        super(name,age,height);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Hùng", 35, 1.71f);
        employee.getInfo();
    }
}
