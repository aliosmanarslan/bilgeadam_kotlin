package _2_weather;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XmlService {

    public List<Weather> weather() {

        List<Weather> ls = new ArrayList<>();
        try {

            String url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml";
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());

            Elements elements = doc.getElementsByTag("sehirler");
            for ( Element item : elements ) {
                String bolge = item.getElementsByTag("bolge").text();
                String peryot = item.getElementsByTag("peryot").text();
                String sehir = item.getElementsByTag("ili").text();
                String merkez = item.getElementsByTag("merkez").text();
                String durum = item.getElementsByTag("durum").text();
                int derece = Integer.parseInt(item.getElementsByTag("mak").text());

                String newsDate = item.getElementsByTag("date").text();


                Weather weather = new Weather(bolge, peryot, sehir, merkez, durum, derece);
                ls.add(weather);
            }

        }catch (Exception ex) {
            System.err.println("Hava Durumu Error:" + ex);
        }
        return ls;

    }

}
