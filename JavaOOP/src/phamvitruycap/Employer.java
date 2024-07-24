package phamvitruycap;

public class Employer {
    //Phạm vi truy cập private

    private String name = "Phương";
    private int age = 30;

   private  void getInfoPrivate(){
        System.out.println(name);
        System.out.println(age);
    }
    //Phạm vi truy cập protected - truy cập sang class khác nhưng phải cùng trong pakage
    protected void getInfoProtected(){
        System.out.println(name);
        System.out.println(age);

    }

    public static void main(String[] args) {
        Employer employer = new Employer();
        employer.getInfoPrivate();
    }

}
