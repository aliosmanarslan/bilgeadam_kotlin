package json_parser;
import java.util.Scanner;

public class NumberControl {
    boolean isInt = false;
    Scanner scanner = new Scanner(System.in);
    public int control(int start){
        do{
        System.out.print("0 ila 10 araliginda bir sayi giriniz: ");
        if(scanner.hasNextInt()){ // This checks to see if the next input is a valid **int**
            start = scanner.nextInt();
            if (start>=0 && start<11)
                isInt = true;
        }
        else{
            System.out.print("Gecersiz deger girdiniz.\n");
            scanner.next();
        }
    }while(isInt == false);
        return start;
    }
}
