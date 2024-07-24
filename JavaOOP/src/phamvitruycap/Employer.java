package phamvitruycap;

public class Employer {
    //Phạm vi truy cập private

    private String name = "Phương";
    private int age = 30;
    public String company;

   private  void getInfoPrivate(){
        System.out.println(name);
        System.out.println(age);
       System.out.println(company);
    }
    //Phạm vi truy cập protected - truy cập sang class khác nhưng phải cùng trong pakage
    protected void getInfoProtected(){
        System.out.println(name);
        System.out.println(age);

    }

    void getInfoDefault(){
        System.out.println( "Đây là hàm Default");
    }

// Phạm vi truy cập public: truy cập mọi nơi trong project
    public  String getName(){
       return name;
    }
    public String getCompany(){
       return company;
    }


    public static void main(String[] args) {
        Employer employer = new Employer();
        employer.getInfoPrivate();
    }

}
