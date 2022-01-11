package _products;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Product {

    @SerializedName("situation")
    @Expose
    private Boolean durum;
    @SerializedName("message")
    @Expose
    private String mesaj;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("Information")
    @Expose
    private List<Information> Info = null;

    public Boolean getDurum() {
        return durum;
    }

    public void setDurum(Boolean durum) {
        this.durum = durum;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Information> getBilgiler() {
        return Information;
    }

    public void setBilgiler(List<Information> Information) {
        this.Info = Info;
    }

}
