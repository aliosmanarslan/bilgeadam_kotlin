package _mainApp;

import _products.Information;
import _products.allInformation;
import _InformationServices.JsonService;
import service.JsonService;
import util.Control;
import java.util.Scanner;

public class mainAppJava {

    public static void main(String[] args) {

        while (true){
            Control control = new Control();
            JsonService jsonService = new JsonService();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please choose a number between 0 and 10. Which row would you like to start with?. ");
            String input = scanner.next();
            if (control.control(input)){
                if (Integer.parseInt(input) >= 0 && Integer.parseInt(input) <= 10){
                    label:
                    while (true){
                        System.out.println("1 > product Id\n2 < Product Information.");
                        Scanner scanner1 = new Scanner(System.in);
                        String input2 = scanner1.next();
                        switch (input2) {
                            case "1":
                                for (Information data : jsonService.getProduct(input)) {
                                    System.out.println(data.getProductId());
                                }
                                break label;
                            case "2":
                                for (Information data : jsonService.getProduct(input)) {
                                    System.out.println(data.getProductName());
                                }
                                break label;
                            case "3":
                                for (Information data : jsonService.getProduct(input)) {
                                    System.out.println(data.getDescription());
                                }
                                break label;
                            default:
                                System.out.println("Please do not write 6, 7, 8.");
                                break;
                        }
                    }
                    break;
                }else{
                    System.out.println("");
                }
            }else{
                System.out.println("Please select a value between 0 and 10.");
            }
        }
    }
}