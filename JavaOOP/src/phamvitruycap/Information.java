package phamvitruycap;

public class Information {
    public static void main(String[] args) {
        Employer employer = new Employer();
        employer.getInfoProtected();
        employer.getInfoDefault();
        System.out.println(employer.getName());
        System.out.println(employer.getCompany());
    }
}
