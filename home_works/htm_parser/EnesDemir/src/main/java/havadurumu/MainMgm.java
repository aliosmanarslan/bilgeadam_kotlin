package havadurumu;

import java.util.List;

public class MainMgm {
    public static void main(String[] args) {
        MgmService mgmService = new MgmService();
        List<Mgm> ls = mgmService.mgmList();
        ls.forEach(item -> {
            System.out.println("Bölge = " + item.getBolge());
            System.out.println("Şehir = " + item.getSehir());
            System.out.println("Hava durumu = " + item.getHavaDurumu());
            System.out.println("En yüksek sıcaklık = " + item.getMax());
            System.out.println("En düşük sıcaklık = " + item.getMin());
            System.out.println("**********************************************************************");
        });
    }
}
