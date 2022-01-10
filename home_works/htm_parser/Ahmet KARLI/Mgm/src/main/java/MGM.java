public class MGM {
    private String bolge;
    private String peryot;
    private String ili;
    private String merkez;
    private String durum;
    private String mak;
    private String min;
    private String sehirIkon;

    public MGM() {

    }

    public MGM(String bolge, String peryot, String ili, String merkez, String durum, String mak, String min, String sehirIkon) {
        this.bolge = bolge;
        this.peryot = peryot;
        this.ili = ili;
        this.merkez = merkez;
        this.durum = durum;
        this.mak = mak;
        this.min = min;
        this.sehirIkon = sehirIkon;
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

    public String getMak() {
        return mak;
    }

    public void setMak(String mak) {
        this.mak = mak;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getSehirIkon() {return sehirIkon;}

    public void setSehirIkon(String sehirIkon) {this.sehirIkon = sehirIkon;}
}
