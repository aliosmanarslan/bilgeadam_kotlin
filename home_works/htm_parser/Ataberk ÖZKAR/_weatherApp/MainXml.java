package _weatherApp;

import java.util.List;

public class MainXml {

    public static void main(String[] args) {

        Services xml = new Services();
        List<weather> ls = xml.wthr();

        ls.stream()
                //.filter( item -> item.getIliName().contains("ANTALYA") );
                .forEach( item -> {
                    System.out.println(item.getMerkezName());
                } );

    }

}
