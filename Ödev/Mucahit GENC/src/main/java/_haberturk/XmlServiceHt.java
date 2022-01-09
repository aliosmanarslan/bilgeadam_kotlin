package _haberturk;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;


public class XmlServiceHt {

    public List<HT> haberturk(){
        List<HT> ls = new ArrayList<>();
        try {
            String url ="https://www.haberturk.com/rss/manset.xml";
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(1000).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());

            Elements elements = doc.getElementsByTag("item");
            for (Element item : elements){
                String category = item.getElementsByTag("category").text();
                String title = item.getElementsByTag("title").text();
                String description = item.getElementsByTag("description").text();
                String pubDate = item.getElementsByTag("pubDate").text();
                String image = item.getElementsByTag("image").text();
                String link = item.getElementsByTag("link").text();
                String guid = item.getElementsByTag("guid").text();

                HT haberturk = new HT(category,title,description,pubDate,image,link,guid);
                ls.add(haberturk);

            }
        }catch (Exception ex){
            System.err.println("Haberturk Error: " + ex);
        }
        return ls;
    }



}
