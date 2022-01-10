package _weatherApp;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
public class Services {

    public List<weather> wthr() {  // created list

        List<weather> ls = new ArrayList<>(); // created arraylist we don't need LinkedList so used ArrayList
        try {

            String url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml"; //determined xml link for all data
            //connected with Jsoup and givin time out value
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());


            //I have made naming so that I can get the data properly.
            Elements elements = doc.getElementsByTag("sehirler");
            for ( Element item : elements ) {
                String bolgeName = item.getElementsByTag("Bolge").text();
                String peryotName = item.getElementsByTag("Peryot").text();
                String iliName = item.getElementsByTag("ili").text();
                String merkezName = item.getElementsByTag("Merkez").text();
                String durumName = item.getElementsByTag("Durum").text();
                String makVal = item.getElementsByTag("Mak").text();
                String minVal = item.getElementsByTag("Min").text();

                weather wthr = new weather( bolgeName, peryotName, iliName, merkezName, durumName, makVal, minVal);
                ls.add(wthr);
            }
         // Put try catch method for any error
        }catch (Exception err) {
            System.err.println("Weather Error:" + err);
        }

        return ls;

    }


}
