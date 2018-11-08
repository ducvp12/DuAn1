package vn.edu.poly.qunlvtnui.model;

public class Quanly {
    private String name;
    private String trangthai;
    private String soluong;

    public Quanly(String name, String trangthai, String soluong) {
        this.name = name;
        this.trangthai = trangthai;
        this.soluong = soluong;
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
