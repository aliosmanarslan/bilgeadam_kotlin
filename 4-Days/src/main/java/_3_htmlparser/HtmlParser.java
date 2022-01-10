package _3_htmlparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class HtmlParser {

    public void HaberlerManset() {

        try {

            String url = "https://www.haberler.com/";
            Document doc = Jsoup.connect(url).get();
            //System.out.println( doc.title() );

            Elements elements = doc.select("#slides > a");
            for ( Element item : elements ) {

                String title = item.attr("title");
                String href = item.attr("href");

                // news img
                String imgURL = item.select("img").get(0).attr("data-src");

                System.out.println(title);
                System.out.println(href);
                System.out.println(imgURL);
                System.out.println("==================================");

            }

        }catch (Exception ex) {
            System.err.println("HaberlerManset Error : " + ex);
        }

    }


}
