package havadurumu;

public class Mgm {
    private String bolge;
    private String sehir;
    private String  max;
    private String  min;
    private String havaDurumu;

    public Mgm(String bolge, String sehir,String max,String min, String havaDurumu) {
        this.bolge = bolge;
        this.sehir = sehir;
        this.max = max;
        this.min = min;
        this.havaDurumu = havaDurumu;
    }

    public void setBolge(String bolge) {
        this.bolge = bolge;
    }
    public String getBolge() {
        return bolge;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
    public String getSehir() {
        return sehir;
    }

    public void setMax(String max) {
        this.max = max;
    }
    public String getMax() {
        return max;
    }

    public void setMin(String min) {
        this.min = min;
    }
    public String getMin() {
        return min;
    }

    public void setHavaDurumu(String havaDurumu) {
        this.havaDurumu = havaDurumu;
    }
    public String getHavaDurumu() {
        return havaDurumu;
    }
}
