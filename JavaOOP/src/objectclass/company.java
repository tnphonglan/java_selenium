package objectclass;

import java.util.ArrayList;

public class company {
    public static void main(String[] args) {

        // Khởi tạo đối tượng class SinhVien
        SinhVien sv1 = new SinhVien("Mai Anh", 40, "Hà Nội", "Auto Test");
        //sv1.printInfo();

        SinhVien sv2 = new SinhVien("Minh Hằng", 25, "HCM", "Auto Test");
        //sv2.printInfo();

        SinhVien sv3 = new SinhVien("Tấn Minh", 35, "Đà Nẵng", "Auto Test");
        sv3.printInfo();

        ArrayList<SinhVien> ListSinhVien = new ArrayList<>();
        ListSinhVien.add(sv1);//Thêm bộ data sv1 vào vị trí đầu tiên trong arraylist
        ListSinhVien.add(sv2);

        for (SinhVien sv : ListSinhVien){
            System.out.println("************");
            sv.printInfo();
        }
    }
}
