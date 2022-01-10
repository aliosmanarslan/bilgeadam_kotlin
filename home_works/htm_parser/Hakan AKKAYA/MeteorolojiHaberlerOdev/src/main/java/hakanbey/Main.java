package hakanbey;

import model.Kemo;
import model.Sehir;
import service.XmlService;

import java.util.*;

public class Main {
    //  Servisi tanımlayalım
    private static XmlService xmlService;

    //  Kullanacağımız nesneleri oluşturalım
    private static Kemo kemo;
    private static List<Sehir> sehirList;

    public static void main(String[] args) {
        System.out.println("<------------------------- Meteoroloji Bilgilendirme ------------------------->");

        //  Servisten yeni bir nesne türetelim
        xmlService = new XmlService();

        //  Kemo verilerini çekelim
        kemo = xmlService.getKemo();

        //  Tüm şehir bilgilerini çekelim
        sehirList = new ArrayList<>(xmlService.getCities());

        System.out.println(
                "Tarih\t\t\t\t: " + kemo.getTarih() + System.lineSeparator() +
                        "Yayın Numarası\t\t: " + kemo.getYayinNo() + System.lineSeparator() +
                        "Periyot Başlama\t\t: " + kemo.getPeryotBaslama() + System.lineSeparator() +
                        "Periyot Bitiş\t\t: " + kemo.getPeryotBitis() + System.lineSeparator() +
                        "Genel Durum\t\t\t: " + kemo.getGenelDurum() + System.lineSeparator() +
                        "Last Updated\t\t: " + new Date(System.currentTimeMillis())
        );
        System.out.println("\n<------------------------- Menüden Seçim Yaparak İstediğiniz Bilgiye Ulaşabilirsiniz ------------------------->\n");

        //  Kullanıcıdan Giriş Al
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1- Tüm Meteoroloji Bilgisini Göster" + System.lineSeparator() +
                    "\t11- Sadece Deniz Hava Durumlarını Göster" + System.lineSeparator() +
                    "\t12- Bölgelere Göre Hava Durumunu Göster" + System.lineSeparator() +
                    "2- Tüm Şehirlerin Hava Durumu Bilgisini Göster" + System.lineSeparator() +
                    "\t21- Şehir Ara" + System.lineSeparator() +
                    "3- Tüm Verileri Güncelle" + System.lineSeparator() +
                    "4- Çıkış");
            //  Kullanıcının seçtiği başlık
            int selected = scanner.nextInt();
            if (selected == 1) {
                tumMeteorolojiBilgisiniGetir();
            } else if (selected == 11) {
                sadeceDenizMeteorolojiBilgisiniGetir();
            } else if (selected == 12) {
                bolgelereGoreMeteorolojiBilgisiniGetir();
            } else if (selected == 2) {
                tumSehirlerinBilgisiniGetir();
            } else if (selected == 21) {
                System.out.print("Şehrin ismini yazınız: ");
                String istenen = scanner.next();
                istenenSehrinBilgisiniGetir(istenen.toLowerCase(Locale.getDefault()));
            } else if (selected == 3) {
                tumVerileriGuncelle();
            } else if (selected == 4) {
                break;
            } else {
                System.out.println("**- Lütfen geçerli bir işlem numarası girin. -**");
            }
        }
    }

    private static void tumMeteorolojiBilgisiniGetir() {
        System.out.println("<---------------Tüm Meteoroloji Bilgisi-------------->");
        System.out.println(
                "Hava Sıcaklığı\t\t\t\t: " + kemo.getHavaSicakligi() + System.lineSeparator() +
                        "Rüzgar Durumu\t\t\t\t: " + kemo.getRuzgarDurum() + System.lineSeparator() +
                        "Deniz Durumu\t\t\t\t: " + kemo.getDenizDurum() + System.lineSeparator() +
                        "Deniz Karadeniz\t\t\t\t: " + kemo.getDenizKaradeniz() + System.lineSeparator() +
                        "Deniz Marmara\t\t\t\t: " + kemo.getDenizMarmara() + System.lineSeparator() +
                        "Deniz Ege\t\t\t\t\t: " + kemo.getDenizEge() + System.lineSeparator() +
                        "Deniz Akdeniz\t\t\t\t: " + kemo.getDenizAkdeniz() + System.lineSeparator() +
                        "Uyarı 1\t\t\t\t\t\t: " + kemo.getUyari1() + System.lineSeparator() +
                        "Uyarı 2\t\t\t\t\t\t: " + kemo.getUyari2() + System.lineSeparator() +
                        "Uyarı 3\t\t\t\t\t\t: " + kemo.getUyari3() + System.lineSeparator() +
                        "Uyarı 4\t\t\t\t\t\t: " + kemo.getUyari4() + System.lineSeparator() +
                        "Uyarı 5\t\t\t\t\t\t: " + kemo.getUyari5() + System.lineSeparator() +
                        "Uyarı 6\t\t\t\t\t\t: " + kemo.getUyari6() + System.lineSeparator() +
                        "Uyarı 7\t\t\t\t\t\t: " + kemo.getUyari7() + System.lineSeparator() +
                        "Uyarı 8\t\t\t\t\t\t: " + kemo.getUyari8() + System.lineSeparator() +
                        kemo.getBolgeAdi0() + " Bölgesi\t\t\t\t: " + kemo.getBolgeDurum0() + System.lineSeparator() +
                        kemo.getBolgeAdi1() + " Bölgesi\t\t\t\t\t: " + kemo.getBolgeDurum1() + System.lineSeparator() +
                        kemo.getBolgeAdi2() + " Bölgesi\t\t\t\t: " + kemo.getBolgeDurum2() + System.lineSeparator() +
                        kemo.getBolgeAdi3() + " Bölgesi\t\t\t: " + kemo.getBolgeDurum3() + System.lineSeparator() +
                        kemo.getBolgeAdi4() + " Bölgesi\t\t: " + kemo.getBolgeDurum4() + System.lineSeparator() +
                        kemo.getBolgeAdi5() + " Bölgesi\t: " + kemo.getBolgeDurum5() + System.lineSeparator() +
                        kemo.getBolgeAdi6() + " Bölgesi\t\t\t: " + kemo.getBolgeDurum6() + System.lineSeparator() +
                        kemo.getBolgeAdi7() + " Bölgesi\t: " + kemo.getBolgeDurum7() + System.lineSeparator() +
                        "Hazırlayan Ekip\t\t\t\t: " + kemo.getHazirlayanEkip() + System.lineSeparator() +
                        "Resim\t\t\t\t\t\t: " + kemo.getResim()
        );
        System.out.println("<---------------Tüm Meteoroloji Bilgisi-------------->");
    }

    private static void sadeceDenizMeteorolojiBilgisiniGetir() {
        System.out.println("<---------------Sadece Deniz Meteoroloji Bilgisi-------------->");
        System.out.println(
                "Deniz Durumu\t\t\t\t: " + kemo.getDenizDurum() + System.lineSeparator() +
                        "Deniz Karadeniz\t\t\t\t: " + kemo.getDenizKaradeniz() + System.lineSeparator() +
                        "Deniz Marmara\t\t\t\t: " + kemo.getDenizMarmara() + System.lineSeparator() +
                        "Deniz Ege\t\t\t\t\t: " + kemo.getDenizEge() + System.lineSeparator() +
                        "Deniz Akdeniz\t\t\t\t: " + kemo.getDenizAkdeniz()
        );
        System.out.println("<---------------Sadece Deniz Meteoroloji Bilgisi-------------->");
    }

    private static void bolgelereGoreMeteorolojiBilgisiniGetir() {
        System.out.println("<---------------Bölgelere Göre Meteoroloji Bilgisi-------------->");
        System.out.println(
                kemo.getBolgeAdi0() + " Bölgesi\t\t\t\t: " + kemo.getBolgeDurum0() + System.lineSeparator() +
                        kemo.getBolgeAdi1() + " Bölgesi\t\t\t\t\t: " + kemo.getBolgeDurum1() + System.lineSeparator() +
                        kemo.getBolgeAdi2() + " Bölgesi\t\t\t\t: " + kemo.getBolgeDurum2() + System.lineSeparator() +
                        kemo.getBolgeAdi3() + " Bölgesi\t\t\t: " + kemo.getBolgeDurum3() + System.lineSeparator() +
                        kemo.getBolgeAdi4() + " Bölgesi\t\t: " + kemo.getBolgeDurum4() + System.lineSeparator() +
                        kemo.getBolgeAdi5() + " Bölgesi\t: " + kemo.getBolgeDurum5() + System.lineSeparator() +
                        kemo.getBolgeAdi6() + " Bölgesi\t\t\t: " + kemo.getBolgeDurum6() + System.lineSeparator() +
                        kemo.getBolgeAdi7() + " Bölgesi\t: " + kemo.getBolgeDurum7()
        );
        System.out.println("<---------------Bölgelere Göre Meteoroloji Bilgisi-------------->");
    }

    private static void tumSehirlerinBilgisiniGetir() {
        System.out.println("<---------------Tüm Şehirleri Meteoroloji Bilgisi-------------->");
        for (Sehir sehir : sehirList) {
            System.out.println(
                    "Bölge\t\t\t\t: " + sehir.getBolge() + System.lineSeparator() +
                            "Periyot\t\t\t\t: " + sehir.getPeryot() + System.lineSeparator() +
                            "İl\t\t\t\t\t: " + sehir.getIli() + System.lineSeparator() +
                            "Merkez\t\t\t\t: " + sehir.getMerkez() + System.lineSeparator() +
                            "Durum\t\t\t\t: " + sehir.getDurum() + System.lineSeparator() +
                            "Maksimum\t\t\t: " + sehir.getMaksimum() + " °C" + System.lineSeparator() +
                            "Minimum\t\t\t\t: " + sehir.getMinimum() + " °C" + System.lineSeparator() +
                            "İkon\t\t\t\t: " + sehir.getSehirIcon() + System.lineSeparator()
            );
        }
        System.out.println("<---------------Tüm Şehirleri Meteoroloji Bilgisi-------------->");

    }

    private static void istenenSehrinBilgisiniGetir(String istenen) {
        System.out.println("<---------------" + istenen.toUpperCase(Locale.getDefault()) + " Şehrinin Meteoroloji Bilgisi-------------->");
        sehirList.stream().filter(item -> item.getIli().toLowerCase(Locale.getDefault()).contains(istenen))
                .forEach(item -> System.out.println(
                        "Bölge\t\t\t\t: " + item.getBolge() + System.lineSeparator() +
                                "Periyot\t\t\t\t: " + item.getPeryot() + System.lineSeparator() +
                                "İl\t\t\t\t\t: " + item.getIli() + System.lineSeparator() +
                                "Merkez\t\t\t\t: " + item.getMerkez() + System.lineSeparator() +
                                "Durum\t\t\t\t: " + item.getDurum() + System.lineSeparator() +
                                "Maksimum\t\t\t: " + item.getMaksimum() + " °C" + System.lineSeparator() +
                                "Minimum\t\t\t\t: " + item.getMinimum() + " °C" + System.lineSeparator() +
                                "İkon\t\t\t\t: " + item.getSehirIcon() + System.lineSeparator()
                ));
        System.out.println("<---------------" + istenen.toUpperCase(Locale.getDefault()) + " Şehrinin Meteoroloji Bilgisi-------------->");

    }

    private static void tumVerileriGuncelle() {
        try {
            boslukBirak();
            System.out.println("<---------------Güncelleme Başlatılıyor--------------->");
            System.out.println("Meteoroloji servisi güncelleniyor...");
            Thread.sleep(1500);
            long startDate = System.currentTimeMillis();

            //  Kemo verilerini güncelle
            kemo = xmlService.getKemo();

            boslukBirak();
            System.out.println("Meteoroloji servisi güncellendi. Şehir verileri güncelleniyor...");
            Thread.sleep(1500);

            //  Şehir verilerini güncelle
            sehirList = xmlService.getCities();

            boslukBirak();
            System.out.println("Şehir verileri güncellendi.");
            Thread.sleep(1500);

            long endDate = System.currentTimeMillis();

            //  Saniye cinsinden geçen süreyi hesapla
            float gecenSure = Float.parseFloat(String.valueOf(new Date(endDate - startDate).getTime())) / 1000;

            boslukBirak();

            System.out.println("<---------------Güncelleme " + gecenSure + " Saniyede Tamamlandı--------------->");

            boslukBirak();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void boslukBirak() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

}
























