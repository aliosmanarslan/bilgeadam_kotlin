package _2_mgmxml;

public class Sehirler {

    private String bolge;
    private String peryot;
    private String il;
    private String durum;
    private String maxSicaklik;
    private String minSicaklik;

    public Sehirler(String bolge, String peryot, String il, String durum, String maxSicaklik, String minSicaklik) {
        this.bolge = bolge;
        this.peryot = peryot;
        this.il = il;
        this.durum = durum;
        this.maxSicaklik = maxSicaklik;
        this.minSicaklik = minSicaklik;
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

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }

    public String getMaxSicaklik() {
        return maxSicaklik;
    }

    public void setMaxSicaklik(String maxSicaklik) {
        this.maxSicaklik = maxSicaklik;
    }

    public String getMinSicaklik() {
        return minSicaklik;
    }

    public void setMinSicaklik(String minSicaklik) {
        this.minSicaklik = minSicaklik;
    }
}
