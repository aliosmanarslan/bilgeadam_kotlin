package service;

import model.Kemo;
import model.Sehir;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XmlService {

    //  Verileri alacağımız adres
    private final static String URL = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml";

    //  Kemo bilgilerini getiren fonksiyon
    public Kemo getKemo() {
        //  Boş bir kemo nesnesi türetelim
        Kemo kemo = new Kemo();
        try {
            //  String değişken içerisine tüm veriyi aktaralım
            String kemoData = Jsoup.connect(URL).ignoreContentType(true).timeout(15000).get().toString();

            //  Bu verileri bir document nesnesine parse edelim
            Document document = Jsoup.parse(kemoData, "UTF-8", Parser.xmlParser());

            //  Kemo verilerini nesnemize aktaralım ve return edelim
            kemo.setTarih(document.getElementsByTag("Tarih").text());
            kemo.setYayinNo(Integer.parseInt(document.getElementsByTag("YayinNo").text()));
            kemo.setPeryotBaslama(document.getElementsByTag("PeryotBaslama").text());
            kemo.setPeryotBitis(document.getElementsByTag("PeryotBitis").text());
            kemo.setGenelDurum(document.getElementsByTag("GenelDurum").text());
            kemo.setHavaSicakligi(document.getElementsByTag("HavaSicakligi").text());
            kemo.setRuzgarDurum(document.getElementsByTag("RuzgarDurum").text());
            kemo.setDenizDurum(document.getElementsByTag("DenizDurum").text());
            kemo.setDenizKaradeniz(document.getElementsByTag("DenizKaradeniz").text());
            kemo.setDenizMarmara(document.getElementsByTag("DenizMarmara").text());
            kemo.setDenizEge(document.getElementsByTag("DenizEge").text());
            kemo.setDenizAkdeniz(document.getElementsByTag("DenizAkdeniz").text());

            kemo.setUyari1(document.getElementsByTag("Uyari1").text());
            kemo.setUyari2(document.getElementsByTag("Uyari2").text());
            kemo.setUyari3(document.getElementsByTag("Uyari3").text());
            kemo.setUyari4(document.getElementsByTag("Uyari4").text());
            kemo.setUyari5(document.getElementsByTag("Uyari5").text());
            kemo.setUyari6(document.getElementsByTag("Uyari6").text());
            kemo.setUyari7(document.getElementsByTag("Uyari7").text());
            kemo.setUyari8(document.getElementsByTag("Uyari8").text());

            kemo.setBolgeAdi0(document.getElementsByTag("BolgeAdi0").text());
            kemo.setBolgeDurum0(document.getElementsByTag("BolgeDurum0").text());
            kemo.setBolgeAdi1(document.getElementsByTag("BolgeAdi1").text());
            kemo.setBolgeDurum1(document.getElementsByTag("BolgeDurum1").text());
            kemo.setBolgeAdi2(document.getElementsByTag("BolgeAdi2").text());
            kemo.setBolgeDurum2(document.getElementsByTag("BolgeDurum2").text());
            kemo.setBolgeAdi3(document.getElementsByTag("BolgeAdi3").text());
            kemo.setBolgeDurum3(document.getElementsByTag("BolgeDurum3").text());
            kemo.setBolgeAdi4(document.getElementsByTag("BolgeAdi4").text());
            kemo.setBolgeDurum4(document.getElementsByTag("BolgeDurum4").text());
            kemo.setBolgeAdi5(document.getElementsByTag("BolgeAdi5").text());
            kemo.setBolgeDurum5(document.getElementsByTag("BolgeDurum5").text());
            kemo.setBolgeAdi6(document.getElementsByTag("BolgeAdi6").text());
            kemo.setBolgeDurum6(document.getElementsByTag("BolgeDurum6").text());
            kemo.setBolgeAdi7(document.getElementsByTag("BolgeAdi7").text());
            kemo.setBolgeDurum7(document.getElementsByTag("BolgeDurum7").text());

            kemo.setHazirlayanEkip(document.getElementsByTag("HazirlayanEkip").text());
            kemo.setResim(document.getElementsByTag("Resim").text());
            kemo.setResimTur(document.getElementsByTag("ResimTur").text());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kemo;
    }

    //  Şehirlerin hava durumu bilgisini getiren fonksiyon
    public List<Sehir> getCities() {
        List<Sehir> sehirList = new ArrayList<>();
        try {
            //  String değişken içerisine tüm veriyi aktaralım
            String sehirData = Jsoup.connect(URL).ignoreContentType(true).timeout(15000).get().toString();

            //  Bu verileri bir document nesnesine parse edelim
            Document document = Jsoup.parse(sehirData, "UTF-8", Parser.xmlParser());

            //  Şehirlerin hepsini Elements değişkenine aktaralım
            Elements elements = document.getElementsByTag("sehirler");

            //  Sehir verilerini listeye ekleyelim ve return edelim
            for (Element element : elements) {
                Sehir sehir = new Sehir();
                sehir.setBolge(element.getElementsByTag("Bolge").text());
                sehir.setPeryot(element.getElementsByTag("Peryot").text());
                sehir.setIli(element.getElementsByTag("ili").text());
                sehir.setMerkez(element.getElementsByTag("Merkez").text());
                sehir.setDurum(element.getElementsByTag("Durum").text());

                if (!element.getElementsByTag("Mak").text().isEmpty())
                    sehir.setMaksimum(Integer.parseInt(element.getElementsByTag("Mak").text()));
                else
                    sehir.setMaksimum(0);

                if (!element.getElementsByTag("Min").text().isEmpty())
                    sehir.setMinimum(Integer.parseInt(element.getElementsByTag("Min").text()));
                else
                    sehir.setMinimum(0);

                sehir.setSehirIcon(element.getElementsByTag("SehirIkon").text());
                sehirList.add(sehir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sehirList;
    }


}
