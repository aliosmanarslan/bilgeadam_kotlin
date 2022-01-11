package mainpackage;

import product.Bilgiler;
import product.ProductJson;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProduct {

    public static void main(String[] args) {
        ProductService productService= new ProductService();


        System.out.print("Lütfen bir tam sayı giriniz (0-10) : ");
        Scanner scanner = new Scanner(System.in);


        while (!scanner.hasNextInt() ) {
            System.out.println("Girdiğiniz veri bir sayı değil.Lütfen bir sayı giriniz :");
            scanner.nextLine();
        }

        int number = scanner.nextInt();

           while(number<0 || number>10) {
               System.out.println("Belirtilen aralıkta bir tam sayı girmelisiniz.Lütfen geçerli bir tam sayı giriniz (0-10) : ");
               scanner.nextLine();
               number = scanner.nextInt();

           }

        System.out.println("Girilen sayı : "+number);

        ProductJson productJson = productService.productResult(number);
        for(Bilgiler item : productJson.getProducts().get(0).getBilgiler()){
            System.out.println("Product Name : "+item.getProductName());
        }
    }
}