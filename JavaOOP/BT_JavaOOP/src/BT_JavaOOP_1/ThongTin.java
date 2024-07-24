package BT_JavaOOP_1;

public class ThongTin {
    public static void main(String[] args) {
        NhanVien nv1 = new NhanVien("Thương", 35, "Trưởng phòng" );
        System.out.println(nv1.getTen());
        System.out.println(nv1.getTuoi());
        System.out.println(nv1.getChucVu());

    }
}
