package _newsApp;
import java.util.List;
public class main {


      public static void main(String[] args) {
            Service xml =new Service();
            List<news> ls = xml.newss();

          ls.stream()
                  .forEach( item -> {
                      System.out.println(item.getCategory().toUpperCase()+"\n"
                              +item.getTitle()+System.lineSeparator()
                              +item.getDescription()+System.lineSeparator()
                              +item.getPubDate()+System.lineSeparator());
                  });



      }
    }

