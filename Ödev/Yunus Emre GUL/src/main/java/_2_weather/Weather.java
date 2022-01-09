package _2_weather;

public class Weather {

        private String bolge;
        private String peryot;
        private String sehir;
        private String merkez;
        private String durum;
        private int derece; //işlem ihtimaline karşı int olarak tanımladım

    public Weather(String bolge, String peryot, String sehir, String merkez, String durum, int derece) {
        this.bolge = bolge;
        this.peryot = peryot;
        this.sehir = sehir;
        this.merkez = merkez;
        this.durum = durum;
        this.derece = derece;
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

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
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

    public int getDerece() {
        return derece;
    }

    public void setDerece(int derece) {
        this.derece = derece;
    }
}

