import java.util.List;

public class MainXml {

    public static void main(String[] args) {
        XmlService xml=new XmlService();
        List<MGM> ls = xml.mgm();

        ls
                .stream()
                .forEach(item->{
                    System.out.println("Bölge : "+item.getBolge()+" Periyot : " +item.getPeryot()+" İl: "+
                            item.getIli()+" Merkez : "+item.getMerkez()+" Durum : "+item.getDurum()+
                            " Maksimum : "+item.getMak()+" Minimum : "+item.getMin()+" Sehir Ikon : "+item.getSehirIkon());
                });
    }
}