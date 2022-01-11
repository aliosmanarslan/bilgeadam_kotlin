package appPack;

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

    }

}
