package jsonparser;

import product.Bilgiler;
import product.ProductData;

import java.util.Scanner;

public class MainJson {
    private static int Scan(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Lütfen Başlatmak İstediğiniz Değeri Giriniz (Max 10) : ");
            if (scanner.hasNextInt()){
                int start= scanner.nextInt();
                return start;
            }else{
                System.out.println("Lütfen Sayısal Değer Giriniz !!!! ");
                Scan();
                return 0;
            }
    }

    public static void main(String[] args) {
        UserService uService = new UserService();
        int start = Scan();
        ProductData pr = uService.productResult(start);
        for (Bilgiler item : pr.getProducts().get(0).getBilgiler() ) {
            System.out.println(item.getProductName());
        }
    }
}
