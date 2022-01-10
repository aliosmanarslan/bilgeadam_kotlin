package havadurumu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class MgmService {
    List<Mgm> mgmList (){
        List<Mgm> mgmls = new ArrayList<>();
        try {
            String url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml";
            String data = Jsoup.connect(url).get().toString();
            Document doc = Jsoup.parse(data, Parser.xmlParser());
            Elements elements = doc.getElementsByTag("sehirler");
            for ( Element item : elements ) {
                String bolge = item.getElementsByTag("Bolge").text();
                String il = item.getElementsByTag("ili").text();
                String durum = item.getElementsByTag("Durum").text();
                String max = item.getElementsByTag("Mak").text();
                String min = item.getElementsByTag("Min").text();
                Mgm mgm = new Mgm(bolge,il,max,min,durum);
                mgmls.add(mgm);
            }
        }catch (Exception e){
            System.err.println(e);
        }
        return mgmls;
    }
}
