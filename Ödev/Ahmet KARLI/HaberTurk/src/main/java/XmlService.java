import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XmlService {
    public List<HaberTurk> haberTurk() {

        List<HaberTurk> ls= new ArrayList<>();

        try{

            String url = "https://www.haberturk.com/rss/manset.xml";
            String stData = Jsoup.connect(url).ignoreContentType(true).get().toString();

            Document doc=Jsoup.parse(stData, Parser.xmlParser());

            Elements elements=doc.getElementsByTag("item");
            for(Element item:elements){

                String category=item.getElementsByTag("category").text();
                String title=item.getElementsByTag("title").text();
                String description=item.getElementsByTag("description").text();
                String pubDate=item.getElementsByTag("pubDate").text();
                String image=item.getElementsByTag("image").text();
                String link=item.getElementsByTag("link").text();
                String guid=item.getElementsByTag("guid").text();

                HaberTurk hb=new HaberTurk(category,title,description,pubDate,image,link,guid);
                ls.add(hb);
            }

        }catch(Exception ex){
            System.err.println("HaberTurk Error : "+ex);
        }
        return ls;
    }

}