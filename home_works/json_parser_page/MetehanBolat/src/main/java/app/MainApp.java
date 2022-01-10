package app;

import model.Bilgiler;
import service.JsonService;
import util.Control;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        while (true){
            Control control = new Control();
            JsonService jsonService = new JsonService();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hangi sıradan başlamak istersiniz. Lütfen 0 ve 10 dahil arasında bir sayı seçin.");
            String input = scanner.next();
            if (control.control(input)){
                if (Integer.parseInt(input) >= 0 && Integer.parseInt(input) <= 10){
                    label:
                    while (true){
                        System.out.println("1 -> Ürün Id\n2 -> Ürün İsmi\n3 -> Ürün Açıklaması");
                        Scanner scanner1 = new Scanner(System.in);
                        String input2 = scanner1.next();
                        switch (input2) {
                            case "1":
                                for (Bilgiler data : jsonService.getProduct(input)) {
                                    System.out.println(data.getProductId());
                                }
                                break label;
                            case "2":
                                for (Bilgiler data : jsonService.getProduct(input)) {
                                    System.out.println(data.getProductName());
                                }
                                break label;
                            case "3":
                                for (Bilgiler data : jsonService.getProduct(input)) {
                                    System.out.println(data.getDescription());
                                }
                                break label;
                            default:
                                System.out.println("Lütfen sadece 1, 2 veya 3 yazın.");
                                break;
                        }
                    }
                    break;
                }else{
                    System.out.println("Hata! Lütfen 0 ile 10 dahil arasında bir sayı seçin.");
                }
            }else{
                System.out.println("Lütfen sadece sayı giriniz.");
            }
        }
    }
}
