package _3_generic;

import _1_arraylist.Customer;

public class MainGeneric {

    public static void main(String[] args) {

        Action<String> ac = new Action<>();

        int size = ac.size("ali");
        System.out.println(size);

        ac.add("Mehmet");

        Action<Customer> action = new Action<>();

    }

}
