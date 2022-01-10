import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import product.Bilgiler;
import product.ProductData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = " ";
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n");
            System.out.println("#Enter the first index for the data (max 12)");
            System.out.println("#Enter -1 to terminate the program");
            System.out.print("##Your choice : ");
            input = scanner.next();


            if ( isStringInt(input.trim())){
                int start = Integer.parseInt(input.trim());
                if(start>=0){
                    if(start>12){
                        System.out.println("There are already 13 products in total. (0..12)");
                    }
                    else{
                        try {
                            ProductService productService = new ProductService();
                            ProductData productData = productService.productResult(input);
                            printProduct(productData);
                        }catch (Exception exception){
                            System.out.println("ERROR : " + exception);
                        }
                    }
                }
                else{
                    System.out.println("Program finished..");
                    break;

                }

            }else{
                System.out.println("You have entered incorrectly.");
            }


        }
    }
    static void printProduct(ProductData productData){
        for(Bilgiler item : productData.getProducts().get(0).getBilgiler()){
            System.out.println(item.getProductName());
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~");

    }
    static public boolean isStringInt(String s)
    {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }
}
