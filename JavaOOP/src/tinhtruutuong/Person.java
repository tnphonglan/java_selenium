package tinhtruutuong;

abstract class Person {
    protected String ten;
    protected int tuoi;
    protected String cmnd;

    abstract public void showInfo();//Hiển thị thông tin 1 người cơ bản  nhất
    abstract public String getTen();
    abstract public String getCmnd();
    abstract public int getTuoi();
    abstract public String getGioiTinh();
    abstract public String getTrinhDo();
}
