package vn.edu.poly.qunlvtnui.model;

public class Quanly {
    private String name;
    private String trangthai;
    private String soluong;
    private String thoigian;
    private String loaithucan;

    public Quanly(String name, String trangthai, String soluong, String thoigian, String loaithucan) {
        this.name = name;
        this.trangthai = trangthai;
        this.soluong = soluong;
        this.thoigian = thoigian;
        this.loaithucan = loaithucan;
    }

    public Quanly(String name, String trangthai, String soluong) {
        this.name = name;
        this.trangthai = trangthai;
        this.soluong = soluong;

    }

    public Quanly() {

    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getLoaithucan() {
        return loaithucan;
    }

    public void setLoaithucan(String loaithucan) {
        this.loaithucan = loaithucan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }
}
