package _1_news;

import java.util.List;

public class MainXML {

    public static void main(String[] args) {

        XmlService xml = new XmlService();
        List<News> ls = xml.news();

        ls.stream()
                .forEach( item -> {
                    System.out.println(item.getTitle() + " (" + item.getCategory() + ") - " + item.getDescription() + " Tarih: " + item.getDate());

                    //Tüm değerlerin kontrolü için
                    //System.out.println(item.getTitle() + " (" + item.getCategory() + ") - " + item.getDescription() + " - " + item.getUrl() + " - " + item.getImageUrl() + " - " + item.getDate() + " - " + item.getDateString());
                } );
    }
}
