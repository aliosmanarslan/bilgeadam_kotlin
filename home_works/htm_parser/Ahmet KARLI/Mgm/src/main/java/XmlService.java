import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XmlService {
    public List<MGM> mgm() {

        List<MGM> ls= new ArrayList<>();

        try{

            String url = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml";
            String stData = Jsoup.connect(url).ignoreContentType(true).get().toString();

            Document doc=Jsoup.parse(stData, Parser.xmlParser());

            Elements elements=doc.getElementsByTag("sehirler");
            for(Element item:elements){

                String bolge=item.getElementsByTag("Bolge").text();
                String peryot=item.getElementsByTag("Peryot").text();
                String ili=item.getElementsByTag("ili").text();
                String merkez=item.getElementsByTag("Merkez").text();
                String durum=item.getElementsByTag("Durum").text();
                String mak=item.getElementsByTag("Mak").text();
                String min=item.getElementsByTag("Min").text();
                String sehirIkon=item.getElementsByTag("SehirIkon").text();

                MGM mgm=new MGM(bolge,peryot,ili,merkez,durum,mak,min,sehirIkon);
                ls.add(mgm);

            }

        }catch(Exception ex){
            System.err.println("Mgm Error : "+ex);
        }
        return ls;
    }

}