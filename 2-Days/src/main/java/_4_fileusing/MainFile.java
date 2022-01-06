package _4_fileusing;

public class MainFile {

    public static void main(String[] args) {

        // try - catch
        String number = "40";
        int dNumber = 0;
        try {
            dNumber = Integer.parseInt(number);
            int i = 1 / 0;
        }catch ( NumberFormatException ex) {
            System.err.println(ex);
            System.out.println("Lütfen Yaşını Sayısal olarak giriniz!");
        }catch ( ArithmeticException ex ) {
            System.out.println("0'a bölme hatası");
        }finally {
            System.out.println("finally Call");
        }

        System.out.println(dNumber);

        // file Using
        UseFile useFile = new UseFile("sample");
        try {
            //useFile.create();
            //useFile.write("Android");
            //useFile.write("Kotlin");
            //useFile.write("Java");
            useFile.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
