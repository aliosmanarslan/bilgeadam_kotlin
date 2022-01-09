package _haberturk;

import java.util.List;

public class MainHT {
    public static void main(String[] args) {
        XmlServiceHt xml =new XmlServiceHt();
        List<HT> ls = xml.haberturk();

        ls.stream()
                .forEach( item -> {
                    System.out.println("--------"+item.getCategory().toUpperCase()+"-----------\n"
                    +item.getTitle()+System.lineSeparator()
                    +item.getDescription()+System.lineSeparator()
                    +item.getPubDate()+System.lineSeparator()
                    +item.getImage()+System.lineSeparator()
                    +item.getLink()+System.lineSeparator()
                    +item.getGuid()+System.lineSeparator()
                    +item.getGuid()+System.lineSeparator()
                    +"<--------------------------->"+ "\n\n");
                   });


    }
}
