package _1_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataResult {

    public List<User> result( int size ) {

        List<User> ls = new ArrayList<>();
        for( int i = 0; i<size; i++ ) {
            User u = new User();
            u.setUid(i);
            u.setName("Name-"+i);
            u.setEmail("name@mail.com"+i);
            Random random = new Random();
            u.setRnd( random.nextInt(size) );
            ls.add(u);
        }
        return ls;

    }


}
