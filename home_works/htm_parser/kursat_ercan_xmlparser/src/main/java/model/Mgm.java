package model;


public class Mgm {
    String tarih;
    String genelDurum;
    String havaSicakligi;
    String ruzgarDurum;
    String denizDurum;




    public Mgm(String tarih, String genelDurum, String havaSicakligi, String ruzgarDurum, String denizDurum) {
        this.tarih = tarih;
        this.genelDurum = genelDurum;
        this.havaSicakligi = havaSicakligi;
        this.ruzgarDurum = ruzgarDurum;
        this.denizDurum = denizDurum;

    }

    public String getTarih() {
        return tarih;
    }

    public String getGenelDurum() {
        return genelDurum;
    }

    public String getHavaSicakligi() {
        return havaSicakligi;
    }

    public String getRuzgarDurum() {
        return ruzgarDurum;
    }

    public String getDenizDurum() {
        return denizDurum;
    }
}
