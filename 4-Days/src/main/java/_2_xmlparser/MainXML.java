package _2_xmlparser;

import java.util.List;

public class MainXML {

    public static void main(String[] args) {

        XmlService xml = new XmlService();
        List<TCMB> ls = xml.tcmb();

        ls.stream()
                //.filter( item -> item.getCurrencyName().contains("US DOLLAR") )
                .forEach( item -> {
                    System.out.println(item.getBanknoteSelling());
                } );

    }

}
