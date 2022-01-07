package _1_stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainStream {

    public static void main(String[] args) {

        DataResult data = new DataResult();
        List<User> ls = data.result(10000);

        // Stream Time: 40463
        // ParallelStream Time: 5696

        long start = System.currentTimeMillis();
        Predicate<User> pre1 =  item -> item.getRnd() > 100 && item.getRnd() < 500;
        ls
            .stream()
            .filter( pre1 )
                //.sorted( (val1, val2) -> val1.getRnd() - val2.getRnd() )
                .sorted( Comparator.comparingInt(User::getUid).reversed() ) // sıralama
                .map( item -> {
                    item.setName(item.getName().toUpperCase());
                    return  item;
                } ) // Tekil elemaların değişimini yapmak için kullanılır.
            .forEach( item -> {
                System.out.println( item.getName() + " - "  + item.getRnd() + " - " + item.getUid());
                try {
                    Thread.sleep(100);
                }catch (Exception ex) {};
            });
        long end = System.currentTimeMillis();
        long between = end - start;
        System.out.println("Stream Time: "  + between);

        //int idsum = ls.stream().reduce( 0, ( defaultVal, userObj ) -> defaultVal + userObj.getUid(), Integer::sum );
        //System.out.println(idsum);
        //List<User> newLs = ls.stream().filter(pre1).collect(Collectors.toList()); // List Dönüşüm



    }


}
