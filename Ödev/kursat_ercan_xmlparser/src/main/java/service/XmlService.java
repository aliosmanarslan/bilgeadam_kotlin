package service;

import model.Manset;
import model.Mgm;
import model.Sehir;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XmlService implements IXmlService{
    public XmlService(){

    }

    @Override
    public Mgm getMgm(String url) {
        String tarih = "";
        String genelDurum = "";
        String havaSicakligi = "";
        String ruzgarDurum = "";
        String denizDurum = "";
        try {
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(10000).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());

            Elements elements = doc.getElementsByTag("Kemo");
            Element item = elements.get(0);

            tarih = item.getElementsByTag("Tarih").text();
            genelDurum = item.getElementsByTag("GenelDurum").text();
            havaSicakligi = item.getElementsByTag("HavaSicakligi").text();
            ruzgarDurum = item.getElementsByTag("RuzgarDurum").text();
            denizDurum = item.getElementsByTag("DenizDurum").text();

        }catch (Exception e){
            System.err.println("XMLService  -- ERROR : " + e);
        }
        return new Mgm(tarih,genelDurum,havaSicakligi,ruzgarDurum,denizDurum);

    }

    @Override
    public List<Sehir> getSehirler(String url) {
        List<Sehir> sehirList = new ArrayList<>();

        try {
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(10000).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());
            Elements elements = doc.getElementsByTag("sehirler");

            for (Element item : elements){
                String bolge = item.getElementsByTag("Bolge").text();
                String peryot = item.getElementsByTag("Peryot").text();
                String il = item.getElementsByTag("ili").text();
                String merkez = item.getElementsByTag("Merkez").text();
                String durum = item.getElementsByTag("Durum").text();
                String mak = item.getElementsByTag("Mak").text();

                sehirList.add(new Sehir(bolge,peryot,il,merkez,durum,mak));
            }

        }catch (Exception e){
            System.err.println("XMLService  -- ERROR : " + e);
        }

        return sehirList;
    }

    @Override
    public List<Manset> getHaberler(String url) {
        List<Manset> haberList = new ArrayList<>();
        try {
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(10000).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());
            Elements elements = doc.getElementsByTag("item");

            for (Element item : elements){
                String category = item.getElementsByTag("category").text();
                String title = item.getElementsByTag("title").text();
                String description = item.getElementsByTag("description").text();
                String[] temp = description.split("/></a>");
                description = temp[temp.length-1];
                String pubDate = item.getElementsByTag("pubDate").text();
                String image = item.getElementsByTag("image").text();
                String link = item.getElementsByTag("link").text();

                haberList.add(new Manset(category,title,description,pubDate,image,link));
            }

        }catch (Exception e){
            System.err.println("XMLService  -- ERROR : " + e);
        }

        return haberList;
    }
}
