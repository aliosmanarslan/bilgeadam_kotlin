package _2_mgmxml;

public class Kemo {

    private  String tarih;
    private  String peryotBaslama;
    private  String peryotBitis;
    private  String genelDurum;
    private  String havaSicakligi;

    public Kemo(String tarih, String peryotBaslama, String peryotBitis, String genelDurum, String havaSicakligi) {
        this.tarih = tarih;
        this.peryotBaslama = peryotBaslama;
        this.peryotBitis = peryotBitis;
        this.genelDurum = genelDurum;
        this.havaSicakligi = havaSicakligi;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getPeryotBaslama() {
        return peryotBaslama;
    }

    public void setPeryotBaslama(String peryotBaslama) {
        this.peryotBaslama = peryotBaslama;
    }

    public String getPeryotBitis() {
        return peryotBitis;
    }

    public void setPeryotBitis(String peryotBitis) {
        this.peryotBitis = peryotBitis;
    }

    public String getGenelDurum() {
        return genelDurum;
    }

    public void setGenelDurum(String genelDurum) {
        this.genelDurum = genelDurum;
    }

    public String getHavaSicakligi() {
        return havaSicakligi;
    }

    public void setHavaSicakligi(String havaSicakligi) {
        this.havaSicakligi = havaSicakligi;
    }
}
