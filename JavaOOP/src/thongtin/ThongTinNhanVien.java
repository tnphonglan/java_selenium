package thongtin;

import phamvitruycap.Employer;

public class ThongTinNhanVien extends Employer{

    public  void XuLyPhatLuong(){
        getInfoProtected();
    }
    public static void main(String[] args) {
        Employer employer = new Employer();
        System.out.println(employer.getName());
        System.out.println(employer.getCompany());

    }
}
