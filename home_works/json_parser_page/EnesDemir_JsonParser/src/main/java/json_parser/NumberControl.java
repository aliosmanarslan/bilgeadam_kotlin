package json_parser;
import java.util.Scanner;

public class NumberControl {
    boolean isInt = false;
    Scanner scanner = new Scanner(System.in);
    public int control(int start){
        do{
        System.out.print("0 ila 10 araliginda bir sayi giriniz: ");
        if(scanner.hasNextInt()){ // This checks to next input is int
            start = scanner.nextInt();
            if (start>=0 && start<11)//This checks to number range
                isInt = true;
        }
        else{
            System.out.print("Gecersiz deger girdiniz.\n");
            scanner.next();
        }
    }while(isInt == false);// loop until correct value is entered
        return start;
    }
}
