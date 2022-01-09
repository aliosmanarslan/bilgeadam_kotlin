package _2_mgmxml;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        XmlService service = new XmlService();
       List<Sehirler> sehirlerList = service.weather();
       sehirlerList.stream().filter(item -> item.getIl().startsWith("A")).forEach(item->{
           System.out.println(item.getBolge() + " -- " + item.getIl()+" -- "
                   + item.getDurum() + " -- Max Temperature:" + item.getMaxSicaklik());
       });

       List<Kemo> kemoList = service.analysis();
       kemoList.stream().forEach(item -> {
           System.out.println("Tarih:" +item.getTarih() + " Peryot Baslama:"
                   + item.getPeryotBaslama()+ " Peryot Bitis:" + item.getPeryotBitis() + "\n Genel Durum: " + item.getGenelDurum() );
       });
    }
}
