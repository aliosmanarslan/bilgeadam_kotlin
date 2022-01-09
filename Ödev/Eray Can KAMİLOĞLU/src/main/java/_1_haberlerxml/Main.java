package _1_haberlerxml;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        XmlService service = new XmlService();

        List<Haberler> haberler = service.haberGetir();
        haberler.stream().forEach(item -> {
            System.out.println( "Title: " +item.getTitle() + " \n Description: " + item.getDescription());
        });
    }
}
