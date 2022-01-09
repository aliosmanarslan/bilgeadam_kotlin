package _meteoroloji;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class XmlServiceMgm {

    public List<MGM> mgm(){
        List<MGM> ls = new ArrayList<>();
        try {
            String url ="https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml";
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(10000).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());

            Elements elements = doc.getElementsByTag("sehirler");
            for (Element item : elements){
                String bolge = item.getElementsByTag("bolge").text();
                String peryot = item.getElementsByTag("peryot").text();
                String ili = item.getElementsByTag("ili").text();
                String merkez = item.getElementsByTag("merkez").text();
                String durum = item.getElementsByTag("durum").text();
                String mak = item.getElementsByTag("mak").text();
                String min = item.getElementsByTag("min").text();

                MGM mgm = new MGM(bolge,peryot,ili,merkez,durum,mak,min);
                ls.add(mgm);

            }
        }catch (Exception ex){
            System.err.println("Meteoroloji Error: " + ex);
        }
        return ls;
    }


}
