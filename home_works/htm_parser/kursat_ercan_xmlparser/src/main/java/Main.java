import model.Manset;
import model.Mgm;
import model.Sehir;
import service.XmlService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String havaDurumuUrl = "https://www.mgm.gov.tr/FTPDATA/analiz/sonSOA.xml";
        String mansetUrl = "https://www.haberturk.com/rss/manset.xml";

        XmlService xmlService = new XmlService();

        List<Sehir> sehirList = xmlService.getSehirler(havaDurumuUrl);
        Mgm mgm = xmlService.getMgm(havaDurumuUrl);
        havaDurumuMonitor(mgm, sehirList);

        List<Manset> mansetList = xmlService.getHaberler(mansetUrl);
        //mansetMonitor(mansetList);


    }

    static public void havaDurumuMonitor(Mgm mgm, List<Sehir> sehirList){

        System.out.println("Tarih : " + mgm.getTarih());
        System.out.println("Genel Durum : " + mgm.getGenelDurum());
        System.out.println("Hava Sıcaklığı : " + mgm.getHavaSicakligi());
        System.out.println("Rüzgar Durum : " + mgm.getRuzgarDurum());
        System.out.println("Deniz Durum : " + mgm.getDenizDurum());

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

        final int[] count = {0};
        sehirList.forEach(item -> {
            count[0] +=1;
            System.out.println("######## Sehir - " + count[0] + " ########");

            System.out.println("Bolge : " + item.getBolge());
            System.out.println("Peryot : " + item.getPeryot());
            System.out.println("ili : " + item.getIl());
            System.out.println("Merkez : " + item.getMerkez());
            System.out.println("Durum : " + item.getDurum());
            System.out.println("Mak : " + item.getMak());

            System.out.println("\n");

        });
    }

    static public void mansetMonitor(List<Manset> mansetList){
        final int[] count = {0};
        mansetList.forEach(item -> {
            count[0] +=1;
            System.out.println("######## MANSET - " + count[0] + " ########");

            System.out.println("Category : " + item.getCategory());
            System.out.println("Title : " + item.getTitle());
            System.out.println("Description : " + item.getDescription());
            System.out.println("PubDate : " + item.getPubDate());
            System.out.println("Image : " + item.getImage());
            System.out.println("Link : " + item.getLink());

            System.out.println("\n");
        });
    }
}
