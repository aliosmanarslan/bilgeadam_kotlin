package haber_manset;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HaberService {
    List<Haber> haberList(){
        List<Haber> lshaber = new ArrayList<>();
        try {
            String url = "https://www.haberturk.com/rss/manset.xml";
            Document doc = Jsoup.parse(new URL(url).openStream(),"UTF-8","", Parser.xmlParser());
            Elements elements = doc.getElementsByTag("item");
            for (Element item : elements){
                String manset = item.getElementsByTag("title").text().toUpperCase(Locale.ROOT);
                String ic = item.getElementsByTag("description").text();
                //description altında haber detayına ulasmak için "alt" attributekeyine ulaşmak için.
                String icerik = Jsoup.parse(ic).select("img").attr("alt");
                Haber haber = new Haber(manset,icerik);
                lshaber.add(haber);
            }
        }catch (Exception e){
            System.err.println(e);
        }
        return lshaber;
    }
}
