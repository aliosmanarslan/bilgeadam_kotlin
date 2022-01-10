package _2_havadurumu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XmlService {

    public List<MGM> mgm(){

        List<MGM> list = new ArrayList<>();

        try{
            String url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml";
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(17100).get().toString();
            Document document = Jsoup.parse(stData, Parser.xmlParser());

            Elements elements = document.getElementsByTag("sehirler");
            for (Element item : elements){
                String sehirler = item.getElementsByTag("sehirler").text();
                String bolge = item.getElementsByTag("Bolge").text();
                String peryot = item.getElementsByTag("Peryot").text();
                String il = item.getElementsByTag("ili").text();
                String merkez = item.getElementsByTag("Merkez").text();
                String durum = item.getElementsByTag("Durum").text();
                String maxSicaklik = item.getElementsByTag("Mak").text();
                String minSicaklik = item.getElementsByTag("Min").text();

                MGM mgm = new MGM(sehirler, bolge, peryot, il, merkez, durum, maxSicaklik, minSicaklik);
                list.add(mgm);
            }

        }catch (Exception ex){
            System.err.println("Mgm Error : " + ex);
        }

        return list;
    }
}
