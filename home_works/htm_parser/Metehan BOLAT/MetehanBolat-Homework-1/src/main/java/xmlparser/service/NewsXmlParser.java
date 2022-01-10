package xmlparser.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import xmlparser.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class NewsXmlParser {

    public List<NewsModel> news(){

        List<NewsModel> newsList = new ArrayList<>();

        try{
            String url = "https://www.haberturk.com/rss/manset.xml";
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(10000).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());
            Elements elements = doc.getElementsByTag("item");

            for(Element element : elements){
                String category = element.getElementsByTag("category").text();
                String title = element.getElementsByTag("title").text();
                String description = element.getElementsByTag("description").text();

                NewsModel news = new NewsModel(category, title, description);
                newsList.add(news);
            }

        } catch (Exception ex){
            System.out.println("News Error: " + ex);
        }

        return newsList;
    }
}
