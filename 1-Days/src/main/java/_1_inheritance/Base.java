package _1_inheritance;

public class Base {

    public int number = 0;

    public Base() {
        System.out.println("Base Call");
    }

    public Base( int number ) {
        this.number = number;
        System.out.println("Number : " + number);
    }

    public void action() {
        System.out.println("B action Call");
    }

}
