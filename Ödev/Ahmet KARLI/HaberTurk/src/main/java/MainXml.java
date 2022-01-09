import java.util.List;

public class MainXml {

    public static void main(String[] args) {
        XmlService xml=new XmlService();
        List<HaberTurk> ls = xml.haberTurk();

        ls
                .stream()
                .forEach(item->{
                    System.out.println("Category : "+item.getCategory()+" Title : " +item.getTitle()+" Description: "+
                            item.getDescription()+" pubDate : "+item.getPubDate()+" Image : "+item.getImage()+
                            " Link : "+item.getLink()+" Guid : "+item.getGuid());
                });

    }
}