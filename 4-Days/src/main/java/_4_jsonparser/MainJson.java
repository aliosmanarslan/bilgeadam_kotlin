package _4_jsonparser;

import props.product.Bilgiler;
import props.product.ProductData;
import props.register.User;
import props.register.UserRegister;
import sun.jvm.hotspot.asm.Register;

import java.util.Scanner;

public class MainJson {

    public static void main(String[] args) {

        UserService uService = new UserService();
        /*
        System.out.println("Yükleme Başladı");
        User u = uService.login("zehra@mail.com", "12345");
        System.out.println("Yükleme Bitti");
        if ( u != null ) {
            System.out.println(u.getDurum() );
            System.out.println(u.getMesaj() );
            if ( u.getBilgiler() != null ) {
                System.out.println(u.getBilgiler().getUserName());
            }
        }
         */
        /*
        UserRegister u = uService.register("Kenan", "Bil", "5431233223", "kenan@mail.com", "12345");
        User r = u.getUser().get(0);
        System.out.println(r.getMesaj());
        if ( u.getUser().get(0).getKullaniciId() != null ) {
            System.out.println("Kullanıcı kaydı başarılı");
        }
         */

        // kullanıcıdan veri alımı
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen bir sayı giriniz (Max 10)");
        int number = scanner.nextInt();
        System.out.println("Girilen Değer: " + number);

        ProductData pr = uService.productResult();
        for (Bilgiler item : pr.getProducts().get(0).getBilgiler() ) {
            System.out.println(item.getProductName());
        }

    }

}
