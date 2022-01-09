package _1_haberlerxml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XmlService {


    public List<Haberler> haberGetir(){

        List<Haberler> haberler = new ArrayList<>();
        try {
            String url = "https://www.haberturk.com/rss/manset.xml";
            String data = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString();

            Document document =Jsoup.parse(data, Parser.xmlParser());
            Elements elements = document.select("item");

            for (Element element:elements){
                String title = element.select("title").text();
                String desc = element.select("description").text();
                Haberler haber = new Haberler(title,desc);
                haberler.add(haber);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        return haberler;
    }
}
