package _1_arraylist;

import java.util.*;

public class MainArray {

    public static void main(String[] args) {

        List<String> ls1 = new ArrayList<>();
        ArrayList<String> ls2 = new ArrayList<>();

        // add
        ls2.add("Ankara");
        ls2.add("İstanbul");
        ls2.add("Gaziantep");
        ls2.add("İzmir");
        ls2.add("Gaziantep");
        ls2.add("Antalya");
        ls2.add("Gaziantep");

        String[] arr = { "Ankara", "İstanbul", "İzmir" };
        List<String> lsArr = Arrays.asList(arr);
        System.out.println(lsArr);

        // delete
        ls2.remove(2);

        // delete all
        //ls2.clear();

        // sort - Sıralama
        Collections.sort(ls2);

        // valid
        boolean status = ls2.contains("Gaziantep");
        System.out.println("Status :" + status);

        Object num = 100;
        num = "ali";
        // city.equals("Gaziantep")
        // indexs
        for (int i = 0; i < ls2.size(); i++) {
            String city = ls2.get(i);
            if ( city.equals("Gaziantep")  ) {
                System.out.println(i);
            }
        }

        /*
        int j = 0;
        for ( String item : ls2 ) {
            if ( item.equals("Gaziantep") ) {
                System.out.println(j);
            }
            j++;
        }
         */

        // index add
        ls2.add(1, "Bursa");

        // item set
        ls2.set(0, "Samsun");

        System.out.println(ls2);


        // property ArrayList
        List<Customer> ls = new ArrayList<>();
        Customer c1 = new Customer("Ali Bilmem", "ali@mail.com", "12345");
        Customer c2 = new Customer("Veli Bilmem", "veli@mail.com", "12345");
        Customer c3 = new Customer("Zehra Bilmem", "zehra@mail.com", "12345");
        ls.add(c1);
        ls.add(c2);
        ls.add(c3);

        for( Customer item : ls ) {
            System.out.println(item.getEmail());
        }

    }

}
