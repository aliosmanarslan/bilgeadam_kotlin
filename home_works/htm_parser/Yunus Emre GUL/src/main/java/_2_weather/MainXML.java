package _2_weather;

import java.util.List;

public class MainXML {

    public static void main(String[] args) {

        XmlService xml = new XmlService();
        List<Weather> ls = xml.weather();

        ls.stream()
                .forEach( item -> {
                    System.out.println(item.getBolge() + ": " + item.getSehir() + " (" + item.getPeryot()+ ") " + item.getDerece() + " derece - " + item.getDurum());
                    // İl ve Merkez aynı değerleri döndürdüğü için merkez'i çıktıya dahil etmedim
                } );
    }
}
