package _1_haberler;

import java.util.List;
import java.util.Scanner;

public class HaberlerXML {

    public static void main(String[] args) {

        XmlService xmlHaberler = new XmlService();
        List<Haberler> list = xmlHaberler.haberler();

        System.out.println("1- Manşetler için 1'e basınız");
        System.out.println("2- Detaylı okumak için 2'ye basınız");
        Scanner klavyeGirdisi = new Scanner(System.in);
        int klavyedenAlinanVeri = klavyeGirdisi.nextInt();
        switch (klavyedenAlinanVeri){
            case 1: list.stream()
                    .forEach(item ->{
                        System.out.println(item.getTitle());
                    });break;
            case 2: list.stream()
                    .forEach(item ->{
                        System.out.println(item.getTitle());
                        System.out.println(item.getDescription());
                    });break;
            default:
                System.out.println("Hatalı tuşlama yaptınız.");
                break;
        }

    }
}
