package _weatherApp;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;



public class weather {  //created public class name weather


    //For all values I give name with private tag
    private String bolgeName;
    private String peryotName;
    private String iliName;
    private String merkezName;
    private String durumName;
    private String makVal;
    private String minVal;

    // Created and set all values for get and set method
    public weather(String bolgeName, String peryotName, String iliName, String merkezName, String durumName, String makVal, String minVal) {
        this.bolgeName = bolgeName;
        this.peryotName = peryotName;
        this.iliName = iliName;
        this.merkezName = merkezName;
        this.durumName = durumName;
        this.makVal = makVal;
        this.minVal = minVal;
    }
    //Giving all set and get parameters
    public String getBolgeName() {
        return bolgeName;
    }
    public void setBolgeName(String bolgeName) {
        this.bolgeName = bolgeName;
    }


    public String getPeryotName() {
        return peryotName;
    }
    public void setPeryotName(String peryotName) {
        this.peryotName = peryotName;
    }


    public String getIliName() {
        return iliName;
    }
    public void setIliName(String iliName) {
        this.iliName = iliName;
    }


    public String getMerkezName() {
        return merkezName;
    }
    public void setMerkezName(String merkezName) {
        this.merkezName = merkezName;
    }


    public String getDurumName() {
        return durumName;
    }
    public void setDurumName(String durumName) {
        this.durumName = durumName;
    }


    public String getMakVal() {
        return makVal;
    }
    public void setMakVal(String makVal) {
        this.makVal = makVal;
    }

    public String getMinVal() {
        return minVal;
    }
    public void setMinVal(String minVal) {
        this.minVal = minVal;
    }


}
