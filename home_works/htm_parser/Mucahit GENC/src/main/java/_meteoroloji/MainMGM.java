package _meteoroloji;

import java.util.List;

public class MainMGM {
    public static void main(String[] args) {
        XmlServiceMgm xml =new XmlServiceMgm();
        List<MGM> lst = xml.mgm();
        lst.stream()
                .forEach(item -> {
                    System.out.println("-----------"+item.getIli().toUpperCase()+"-----------\n"
                    +"Gün Periyodu : "+item.getPeryot()+System.lineSeparator()
                    +"Bölge : "+item.getBolge()+System.lineSeparator()
                    +"İl Merkezi : "+item.getMerkez()+System.lineSeparator()
                    +"Genel Durum : "+item.getDurum()+System.lineSeparator()
                    +"Maksimum Sıcaklık : "+item.getMak()+System.lineSeparator()
                    +"Minimum Sıcaklık : "+item.getMin()+System.lineSeparator()
                    +"---------------------------"+ "\n\n"
                    );


                });

    }







}
