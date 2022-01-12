package appPack;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        DB db = new DB();

        boolean status = db.login("ali@mail.com", "12345");
        System.out.println("Status :"+ status);

        int row = db.register("Kemal Bil", "kemal@mail.com", "12345");
        if ( row == -1 ) {
            System.out.println("bu mail adresi ile daha önce kayıt yapılmış");
        }
        System.out.println("register :" + row);

        int uRow = db.update(4,"Kemal Bilsin", "kemal@mail.com", "12345");
        System.out.println("update : "+ uRow);

        int dRow = db.delete(1);
        System.out.println("delete : "+ dRow);

        List<User> ls = db.list("");
        ls.forEach( item -> {
            System.out.println(item.getName());
        });


    }

}
