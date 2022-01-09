package _1_news;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class XmlService {

    public List<News> news() {

        List<News> ls = new ArrayList<>();
        try {

            String url = "https://www.haberturk.com/rss/manset.xml";
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());

            Elements elements = doc.getElementsByTag("item");
            for ( Element item : elements ) {
                String newsCategory = item.getElementsByTag("category").text();
                String newsTitle = item.getElementsByTag("title").text();
                String newsDescription = Jsoup.parse(item.getElementsByTag("description").text()).text();
                String newsUrl = Jsoup.parse(item.getElementsByTag("description").text()).select("a").attr("href");
                String newsPictureUrl = Jsoup.parse(item.getElementsByTag("description").text()).select("img").attr("src");;

                //Tarih bilgisini direkt string olarak almak için
                String newsDateString = item.getElementsByTag("pubDate").text();

                //Tarih bilgisini Date formatında almak için. Bu yöntemle saat, bölgesel saate çevirilebilir ve zaman hesapları da yapılabilir.
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);
                Date newsDate = simpleDateFormat.parse(newsDateString);

                News news = new News(newsCategory, newsTitle, newsDescription, newsUrl, newsPictureUrl, newsDateString, newsDate);
                ls.add(news);
            }

        }catch (Exception ex) {
            System.err.println("Habertürk Error:" + ex);
        }

        return ls;

    }

}
