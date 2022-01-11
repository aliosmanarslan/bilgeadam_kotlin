package _jasonParserConnection;

import _products.allInformation;
import product.allInformation;
import product.ProductData;
import java.util.Scanner;

public class jasonParser {
    public static int Scan(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        if (scanner.hasNextInt()){
            int start= scanner.nextInt();
            if (start>0 != start<=10){
                System.out.println("Please Enter the Value You Want(Max 10):");
                Scan();
            }
            return start;
        }else{
            System.out.println("Please enter a correct value ");
            Scan();
            return 0;
        }
    }

    public static void main(String[] args) {
        UserService uService = new UserService();
        int start = Scan();
        ProductData pr = uService.productResult(start);
        for (allInformation item : pr.getProducts().get(0).getBilgiler() ) {
            System.out.println(item.getProductName());
        }
    }
}
