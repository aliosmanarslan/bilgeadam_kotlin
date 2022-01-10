package hakanbey;

import hakanbey.model.Bilgiler;
import hakanbey.model.ProductData;
import hakanbey.service.ProductService;

import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        System.out.println("==========Servis başlatılıyor...==========");
        ProductService service = new ProductService();
        ProductData data = service.getProducts(0);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int selected;
        String start = "0";

        while (true) {
            System.out.println("1- İstenilen Sayfadan İtibaren Göster\n2- Verileri Güncelle\n3- Çıkış");
            selected = scanner.nextInt();
            if (selected == 1) {
                System.out.print("Lütfen başlangıç sayfasını girin (Maksimum " + data.getProducts().get(0).getTotal() + "): ");
                start = scanner2.nextLine();
                if (userTextControl(start)) {
                    int userInput = Integer.parseInt(start);
                    if (userInput > 13) {
                        System.out.println("\n***************************Lütfen " + data.getProducts().get(0).getTotal() + " sayısından fazla giriş yapmayın.\n");
                    }  else {
                        data = service.getProducts(userInput);
                        showProductList(data);
                    }
                } else {
                    System.out.println("\n***************************Lütfen sadece pozitif rakam giriniz.\n");
                }
            } else if (selected == 2) {
                long startDate = System.currentTimeMillis();
                System.out.println("==========Güncelleme başlatılıyor==========");
                data = service.getProducts(Integer.parseInt(start));
                long endDate = System.currentTimeMillis();
                float result = Float.parseFloat(String.valueOf(new Date(endDate - startDate).getTime())) / 1000;
                System.out.println("==========Güncelleme " + result + " Saniyede Tamamlandı==========");
            } else if (selected == 3) {
                break;
            }
        }

    }

    private static void showProductList(ProductData data) {
        try {
            if (data != null) {
                if (!data.getProducts().isEmpty()) {
                    System.out.println("\n==========Ürün Listesi==========");
                    data.getProducts().get(0).
                            getBilgiler().
                            stream().
                            sorted((Comparator.comparing(Bilgiler::getCampaignTitle)))
                            .forEach(item -> {
                                System.out.println("-> " + item.getProductName());
                            });
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.err.println("showProductList Error: " + e);
        }
    }

    private static boolean userTextControl(String userText) {
        try {
            int count = 0;
            char[] userTextChar = userText.toCharArray();

            for (int i = 0; i < userTextChar.length; i++) {
                for (int j = 0; j < digits.length; j++) {
                    if (userTextChar[i] == digits[j]) {
                        count += 1;
                    }
                }
            }
            if (count == userTextChar.length)
                return true;
            else
                return false;
        } catch (Exception e) {
            System.err.println("control Error: " + e);
            return false;
        }
    }
}
