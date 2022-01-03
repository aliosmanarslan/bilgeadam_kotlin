package _1_inheritance;

public class A extends Base {

    public A () {
        super(100);
    }

    @Override
    public void action() {
        System.out.println("A action Call :" + number );
    }

    public void sum( int a, int b ) {
        int sm = a + b;
        System.out.println("Sum : " + sm);
        if ( sm > 20) {
            action();
        }else {
            super.action();
        }
    }

}
