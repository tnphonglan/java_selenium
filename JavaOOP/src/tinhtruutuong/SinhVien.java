package tinhtruutuong;

public class SinhVien extends Person{

    public SinhVien(String ten, int tuoi, String cmnd){
        this.ten = ten;
        this.tuoi = tuoi;
        this.cmnd = cmnd;

    }

    @Override
    public void showInfo() {
        System.out.println(ten);
        System.out.println(tuoi);
        System.out.println(cmnd);
    }

    @Override
    public String getTen() {
        return "";
    }

    @Override
    public String getCmnd() {
        return "";
    }

    @Override
    public int getTuoi() {
        return 0;
    }

    @Override
    public String getGioiTinh() {
        return "";
    }

    @Override
    public String getTrinhDo() {
        return "";
    }

    public static void main(String[] args) {
        SinhVien sinhVien = new SinhVien("Lan", 25, "25468791");

        sinhVien.showInfo();
    }
}
