package _2_xmlparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XmlService {

    public List<TCMB> tcmb() {

        List<TCMB> ls = new ArrayList<>();
        try {

            String url = "https://www.tcmb.gov.tr/kurlar/today.xml";
            String stData = Jsoup.connect(url).ignoreContentType(true).timeout(15000).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());

            Elements elements = doc.getElementsByTag("Currency");
            for ( Element item : elements ) {
                String currencyName = item.getElementsByTag("CurrencyName").text();
                String forexBuying = item.getElementsByTag("ForexBuying").text();
                String forexSelling = item.getElementsByTag("ForexSelling").text();
                String banknoteBuying = item.getElementsByTag("BanknoteBuying").text();
                String banknoteSelling = item.getElementsByTag("BanknoteSelling").text();

                TCMB tcmb = new TCMB(currencyName,forexBuying, forexSelling, banknoteBuying, banknoteSelling);
                ls.add(tcmb);
            }

        }catch (Exception ex) {
            System.err.println("Tcmb Error:" + ex);
        }

        return ls;

    }


}
