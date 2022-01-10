package haber_manset;
import java.util.List;

public class MainHaber {
    public static void main(String[] args) {
        HaberService haberService = new HaberService();
        List<Haber> ls = haberService.haberList();
        ls.stream().forEach(item -> {
            System.out.println(item.getManset());
            System.out.println(item.getIcerik());
            System.out.println("**********************************************************");
        });

    }
}
