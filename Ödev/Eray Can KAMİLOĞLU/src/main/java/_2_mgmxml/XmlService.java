package _2_mgmxml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XmlService {

    String url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml";

    public List<Sehirler> weather(){

        List<Sehirler> sehirler = new ArrayList<>();

        try {

            String data = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString();
            Document document = Jsoup.parse(data, Parser.xmlParser());
            Elements elements = document.getElementsByTag("sehirler");

            for (Element element: elements){

                String bolge = element.getElementsByTag("Bolge").text();
                String peryot = element.getElementsByTag("Peryot").text();
                String il = element.getElementsByTag("ili").text();
                String durum = element.getElementsByTag("Durum").text();
                String max = element.getElementsByTag("Mak").text();
                String min = element.getElementsByTag("Min").text();

                Sehirler sehir = new Sehirler(bolge,peryot,il,durum,max,min);
                sehirler.add(sehir);
            }

        }catch (Exception ex){
            System.err.println(ex);
        }
        return sehirler;
    }

    public List<Kemo> analysis(){

        List<Kemo> kemoList = new ArrayList<>();
        try{
            String data = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString();
            Document document = Jsoup.parse(data,Parser.xmlParser());
            Elements elements = document.getElementsByTag("Kemo");

            for (Element element: elements){
                String tarih = element.getElementsByTag("Tarih").text();
                String peryotBaslama = element.getElementsByTag("PeryotBaslama").text();
                String peryotBitis = element.getElementsByTag("PeryotBitis").text();
                String genelDurum = element.getElementsByTag("GenelDurum").text();
                String havaSicakligi = element.getElementsByTag("HavaSicakligi").text();

                Kemo kemoStatus = new Kemo(tarih,peryotBaslama,peryotBitis,genelDurum,havaSicakligi);
                kemoList.add(kemoStatus);
            }

        }catch (Exception ex){
            System.err.println("Kemo Error: " + ex);
        }
        return kemoList;
    }
}
