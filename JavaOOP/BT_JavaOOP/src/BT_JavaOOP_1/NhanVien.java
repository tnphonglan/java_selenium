package BT_JavaOOP_1;

public class NhanVien {
    String Ten;
    int Tuoi;
    String ChucVu;

    //Hàm xây dựng có tham số
    public NhanVien(String Ten, int Tuoi, String ChucVu){
        this.Ten = Ten;
        this.Tuoi = Tuoi;
        this.ChucVu = ChucVu;
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
