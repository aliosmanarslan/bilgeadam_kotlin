package _2_havadurumu;

import java.util.List;
import java.util.Scanner;

public class MainXML {

    public static void main(String[] args) {

        XmlService xmlHavaDurumu = new XmlService();
        List<MGM> list = xmlHavaDurumu.mgm();

        System.out.println("1- Şehirler ve durum bilgisi için 1'e basınız");
        System.out.println("2- Şehirler ve sıcaklık bilgisi için 2'e basınız");
        Scanner klavyeGirdisi = new Scanner(System.in);
        int klavyedenAlinanVeri = klavyeGirdisi.nextInt();
        switch (klavyedenAlinanVeri){
            case 1: list.stream()
                    .forEach(item ->{
                        System.out.println(item.getIl() + " : " + item.getDurum());
                    });break;
            case 2: list.stream()
                    .forEach(item ->{
                        System.out.println(item.getIl() + " \n " + "Maksimum sıcaklık :" +
                                item.getMaxSicaklik() + " \n" +
                                " Minumum sıcaklık :" + item.getMinSicaklik());
                    });break;
            default:
                System.out.println("Hatalı tuşlama yaptınız.");
                break;
        }
    }
}
