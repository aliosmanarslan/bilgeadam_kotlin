package _newsApp;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public List<news> newss() {  // created list

        List<news> ls = new ArrayList<>(); // created arraylist we don't need LinkedList so used ArrayList
        try {

            String url = "https://www.haberturk.com/rss/manset.xml"; //determined xml link for all data
            //connected with Jsoup and givin time out value
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString();
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

                news newss = new news(category, title, description, pubDate, image, link, guid);
                ls.add(newss);

            }
        }catch (Exception ex){
            System.err.println("news Error: " + ex);
        }
        return ls;


    }


}