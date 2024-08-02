package BT_JavaOOP_1;

public class NhanVien {
    private String Ten;
    private int Tuoi;
    private String ChucVu;

    //Hàm xây dựng có tham số
    public NhanVien(String Ten, int Tuoi, String ChucVu){
        this.Ten = Ten;
        this.Tuoi = Tuoi;
        this.ChucVu = ChucVu;
    }

    public void getThongTinNhanVien(){
        System.out.println(getTen());
        System.out.println(getTuoi());
        System.out.println(getChucVu());
    }

    public int getTuoi() {

        return Tuoi;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public String getTen(){
        return Ten;
    }
}
