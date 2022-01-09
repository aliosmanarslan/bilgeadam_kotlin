package xmlparser.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import xmlparser.model.WeatherModel;

import java.util.ArrayList;
import java.util.List;

public class WeatherXmlParser {

    public List<WeatherModel> weather(){

        List<WeatherModel> weatherList = new ArrayList<>();

        try{
            String url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml";
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(10000).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());
            Elements elements = doc.getElementsByTag("sehirler");

            for(Element element : elements){
                String region = element.getElementsByTag("Bolge").text();
                String period = element.getElementsByTag("Peryot").text();
                String city = element.getElementsByTag("ili").text();
                String situation = element.getElementsByTag("Durum").text();
                String max = element.getElementsByTag("Mak").text();
                String min = element.getElementsByTag("Min").text();

                WeatherModel weather = new WeatherModel(region, period, city, situation, max, min);
                weatherList.add(weather);
            }

        } catch (Exception ex){
            System.out.println("Weather Error: " + ex);
        }

        return weatherList;
    }
}
