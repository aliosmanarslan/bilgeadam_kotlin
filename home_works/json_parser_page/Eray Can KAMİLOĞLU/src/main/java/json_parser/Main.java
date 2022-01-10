package json_parser;

import props.Bilgiler;
import props.ProductData;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);
        int startVal=0;

            try{
                while(true) {
                System.out.print("Lütfen start değerini sayı giriniz(Maksimum 12): ");
                if (scanner.hasNextInt()){
                    startVal = scanner.nextInt();
                    if (startVal<=12) {
                        System.out.println(startVal);
                        break;
                    }
                }else
                scanner.next();
               }
                String start = String.valueOf(startVal);
                ProductData productData = productService.productResult(start);

                for (Bilgiler item : productData.getProducts().get(0).getBilgiler()){
                    System.out.println("Product Name: " + item.getProductName() + " \nBrief:" + item.getBrief());
                }



            }catch (InputMismatchException exception){
                System.err.println( "Lütfen sayi değeri giriniz. " +exception);

            }
}


}
