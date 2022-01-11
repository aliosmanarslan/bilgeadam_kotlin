package json_parser;

import props.products.Bilgiler;
import props.products.ProductData;

import java.util.Scanner;

public class MainProduct {

    public static void main(String[] args) {

        ProductService productService = new ProductService();


        System.out.println("Lütfen bir tam sayı giriniz (Sayı 0 ile 10 arasında olmalıdır)");
        int number = ScanNumber();
        String numberStr = "" + number;

        ProductData pr = productService.productResult(numberStr);

        for (Bilgiler item : pr.getProducts().get(0).getBilgiler() ) {
            System.out.println(item.getProductName());
        }
    }

        public static int ScanNumber()
        {
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {

                int number = scanner.nextInt();

                if (number > 10 || number < 0) {
                    System.out.println("Lütfen 0 ile 10 arasında bir tam sayı giriniz.");
                    ScanNumber();
                }
                else {
                    System.out.println("Girilen Değer: " + number + System.lineSeparator());
                    return number;
                }
            }
            else
            {
                System.out.println("Lütfen sadece tam sayı girişi yapınız.");
                ScanNumber();
            }
            return 0;
        }

    }

