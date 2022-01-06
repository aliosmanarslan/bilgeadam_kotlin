package _2_hashmap;

import java.util.*;

public class MainMap {

    public static void main(String[] args) {

        Map<String, Object> hm = new LinkedHashMap<>();
        HashMap<String, Object> hm1 = new HashMap<>();

        // add item
        hm.put("email", "ali@mail.com");
        hm.put("age", 30);
        hm.put("name", "Ali Bilmem");
        hm.put("status", true);
        hm.put("status", false);

        Map<String,String> hmx = new HashMap<>();
        hmx.put("xxx", "");
        // get item
        String itm = hmx.get("xxx");
        if ( itm != null ) {
            System.out.println( itm.length() );
        }


        // item delete
        //hm.remove("email");

        // Set - Keys
        Set<String> keys = hm.keySet();
        for ( String key : keys ) {
            System.out.println(key + " " + hm.get(key));
        }
        System.out.println(hm);


        // Enum with Map
        Map<EUser, Object > map = new LinkedHashMap<>();
        map.put(EUser.id, 100);
        map.put(EUser.name, "Ali Bilmem");
        map.put(EUser.email, "ali@mail.com");
        map.put(EUser.password, "12345");

        // Get item
        Object name = map.get(EUser.name);
        System.out.println(name);

        // list with map
        List<Map<EUser, Object>> list = new ArrayList<>();

    }

}
