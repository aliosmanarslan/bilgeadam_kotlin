package haber_manset;

public class Haber {
    private String manset;
    private String icerik;

    public Haber(String manset, String icerik) {
        this.manset = manset;
        this.icerik = icerik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getManset() {
        return manset;
    }

    public void setManset(String manset) {
        this.manset = manset;
    }
}
