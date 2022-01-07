package _3_htmlparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class HtmlParser {

    public void HaberlerManset() {

        try {

            String url = "https://www.haberler.com/";
            Document doc = Jsoup.connect(url).get();
            System.out.println( doc.title() );

            Elements elements = doc.select("#slides > a");
            System.out.println(elements);

        }catch (Exception ex) {
            System.err.println("HaberlerManset Error : " + ex);
        }

    }


}
