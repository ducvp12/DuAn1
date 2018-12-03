package vn.edu.poly.qunlvtnui.model;

public class Ghichu {

    private String tieude;
    private String noidung;

    public Ghichu() {
    }

    public Ghichu( String tieude, String noidung) {

        this.tieude = tieude;
        this.noidung = noidung;
    }


    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getTieude() {
        return tieude;
    }

    public String getNoidung() {
        return noidung;
    }
}
