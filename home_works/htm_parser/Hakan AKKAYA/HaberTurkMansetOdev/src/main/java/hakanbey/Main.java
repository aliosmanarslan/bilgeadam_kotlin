package hakanbey;


import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private static Channel data;
    private static XmlService xmlService;
    private static final int HABER_CEKME_HIZI = 1;

    public static void main(String[] args) {
        //  Servisimizden Nesne Türetelim
        xmlService = new XmlService();

        //  Türetilen Nesne Sayesinde Verilerimizi Alalım
        data = xmlService.mansetHaberleriGetir();

        //  XML Sayfa Bilgilerini Yazdıralım
        System.out.println("<------------------------- Haberler.com - Bilgilendirme ------------------------->");
        System.out.println("Site Başlığı\t\t: " + data.getTitle() + System.lineSeparator()
                + "Site\t\t\t\t: " + data.getLink() + System.lineSeparator()
                + "Site Açıklama\t\t: " + data.getDescription() + System.lineSeparator()
                + "Site Dili\t\t\t: " + data.getLanguage() + System.lineSeparator()
                + "Telif Hakkı\t\t\t: " + data.getCopyright() + System.lineSeparator()
                + "Site Kategorisi\t\t: " + data.getCategory() + System.lineSeparator()
                + "Son Güncelleme\t\t: " + data.getLastBuildDate() + System.lineSeparator()
                + "Versiyon\t\t\t: " + data.getTtl());
        System.out.println("<-------------------------------------------------->");

        //  Kullanıcıdan Giriş Al
        Scanner scanner = new Scanner(System.in);
        int select;
        while (true) {
            System.out.println("1- Tüm Haberleri Göster" + System.lineSeparator() +
                    "2- Çıkış");
            select = scanner.nextInt();
            if (select == 1) {
                haberleriYazdir();
            } else if (select == 2) {
                break;
            } else {
                System.out.println("**- Lütfen geçerli bir işlem numarası girin. -**");
            }
        }

    }

    public static void haberleriYazdir() {
        //  Güncel verileri çek
        data = xmlService.mansetHaberleriGetir();

        //  Ekrana Yazdır
        System.out.println("<------------------------- Manşet Haberleri ------------------------->");
        data.getHaberList()
                .stream()
                .sorted(Comparator.comparing(Haber::getPubDate))    //  Haber Paylaşım Tarihine Göre Sırala
                .forEach(item -> {
                    try {
                        Thread.sleep(HABER_CEKME_HIZI);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("Kategori\t\t\t: " + item.getCategory());
                    System.out.println("Başlık\t\t\t\t: " + item.getTitle());
                    System.out.println("Açıklama\t\t\t: " + item.getDescription());
                    System.out.println("Paylaşım Tarihi\t\t: " + item.getPubDate());
                    System.out.println("Resim\t\t\t\t: " + item.getMediaContent());
                    System.out.println("Medya\t\t\t\t: " + item.getMediaContent());
                    System.out.println("Önizleme\t\t\t: " + item.getMediaThumbnail());
                    System.out.println("Enclosure\t\t\t: " + item.getEnclosure());
                    System.out.println("Link\t\t\t\t: " + item.getLink());
                    System.out.println("Guid\t\t\t\t: " + item.getGuid());
                    System.out.println("<------------------------------>");
                });
    }
}
