package _1_haberler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XmlService {
    public List<Haberler> haberler() {

        List<Haberler> list = new ArrayList<>();

        try {
            String url = "https://www.haberturk.com/rss/manset.xml";
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(14500).get().toString();
            Document document = Jsoup.parse(stData, Parser.xmlParser());

            Elements elements = document.getElementsByTag("item");
            for (Element item : elements) {
                String title = item.getElementsByTag("Title").text();
                String description = item.getElementsByTag("Description").text();
                String pubDate = item.getElementsByTag("PubDate").text();
                String link = item.getElementsByTag("Link").text();

                Haberler haberler = new Haberler(title, description, pubDate, link);
                list.add(haberler);
            }

        } catch (Exception ex) {
            System.err.println("Haberler Error : " + ex);
        }

        return list;
    }
}
