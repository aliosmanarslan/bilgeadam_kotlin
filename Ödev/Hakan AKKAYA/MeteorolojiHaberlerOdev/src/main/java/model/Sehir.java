package model;

public class Sehir {
    private String bolge;
    private String peryot;
    private String ili;
    private String merkez;
    private String durum;
    private int maksimum;
    private int minimum;
    private String sehirIcon;

    public Sehir() {
    }

    public String getBolge() {
        return bolge;
    }

    public void setBolge(String bolge) {
        this.bolge = bolge;
    }

    public String getPeryot() {
        return peryot;
    }

    public void setPeryot(String peryot) {
        this.peryot = peryot;
    }

    public String getIli() {
        return ili;
    }

    public void setIli(String ili) {
        this.ili = ili;
    }

    public String getMerkez() {
        return merkez;
    }

    public void setMerkez(String merkez) {
        this.merkez = merkez;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public int getMaksimum() {
        return maksimum;
    }

    public void setMaksimum(int maksimum) {
        this.maksimum = maksimum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public String getSehirIcon() {
        return sehirIcon;
    }

    public void setSehirIcon(String sehirIcon) {
        this.sehirIcon = sehirIcon;
    }
}
