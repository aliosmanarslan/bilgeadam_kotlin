package hakanbey;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class XmlService {

    //  Verileri nereden alacağımızı belirttiğimiz adres
    private final static String URL = "https://www.haberturk.com/rss/manset.xml";

    //  İlgili adresteki tüm haberleri bir liste olarak döndüren fonksiyon
    public Channel mansetHaberleriGetir() {
        Channel data = new Channel();
        try {
            //  Aşağıdaki değişkene URL'nin XML halini aktaran kısım
            String haberData = Jsoup.connect(URL).ignoreContentType(true).timeout(15000).get().toString();

            //  Jsoup Kütüphanesinden Türetilmiş Document içerisine, String verisini parse eden kısım
            Document document = Jsoup.parse(haberData, "UTF-8", Parser.xmlParser());

            //  XML Üst Bilgilerini Set Eden Kısım
            data.setTitle(document.selectFirst("title").text());
            data.setLink(document.selectFirst("link").text());
            data.setDescription(document.selectFirst("description").text());
            data.setLanguage(document.selectFirst("language").text());
            data.setCopyright(document.selectFirst("copyright").text());
            data.setCategory(document.selectFirst("category").text());
            data.setLastBuildDate(document.selectFirst("lastBuildDate").text());
            data.setTtl(Integer.parseInt(document.selectFirst("ttl").text()));

            //  Her bir veriyi alabilmek için TAG belirten kısım
            Elements items = document.getElementsByTag("item");

            //  Her bir veriyi model sınıfına aktarıp, listeye ekleme yapan döngü
            for (Element element : items) {
                Haber haber = new Haber();
                haber.setCategory(element.getElementsByTag("category").text());
                haber.setTitle(element.getElementsByTag("title").text());
                haber.setDescription(element.getElementsByTag("description").text().substring(element.getElementsByTag("description").text().indexOf("</a>") + 4));   //  Açıklamanın daha güzel okunabilmesi için HTML tagları silindi
                haber.setPubDate(element.getElementsByTag("pubDate").text());
                haber.setImage(element.getElementsByTag("image").text());
                haber.setMediaContent(element.getElementsByTag("media:content").attr("url"));
                haber.setMediaThumbnail(element.getElementsByTag("media:thumbnail").attr("url"));
                haber.setEnclosure(element.getElementsByTag("enclosure ").attr("url"));
                haber.setLink(element.getElementsByTag("link").text());
                haber.setGuid(element.getElementsByTag("guid").text());
                //  Haber Listesine Ekleme Yap
                data.getHaberList().add(haber);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
