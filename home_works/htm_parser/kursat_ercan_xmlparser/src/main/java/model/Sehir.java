package model;

public class Sehir {
    private String bolge;
    private String peryot;
    private String il;
    private String merkez;
    private String durum;
    private String mak;

    public Sehir(String bolge, String peryot, String il, String merkez, String durum, String mak) {
        this.bolge = bolge;
        this.peryot = peryot;
        this.il = il;
        this.merkez = merkez;
        this.durum = durum;
        this.mak = mak;
    }

    public String getBolge() {
        return bolge;
    }

    public String getPeryot() {
        return peryot;
    }

    public String getIl() {
        return il;
    }

    public String getMerkez() {
        return merkez;
    }

    public String getDurum() {
        return durum;
    }

    public String getMak() {
        return mak;
    }
}
