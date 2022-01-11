package json_parser;

import java.util.Scanner;

public class DataCheck {

    public int CheckData(){

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Lütfen 0 ile 10 aralığında bir tam sayı giriniz : ");

        if (keyboard.hasNextInt()){

            int readData = keyboard.nextInt();

            if (readData<=10 != readData>0){
                System.out.println("Hatalı değer girdiniz. Tekrar deneyiniz");
                CheckData();
            }

            return readData;
        }else {

            System.out.println("Lütfen tam sayı değeri giriniz. ");
            CheckData();

            return 0;
        }

    }
}
