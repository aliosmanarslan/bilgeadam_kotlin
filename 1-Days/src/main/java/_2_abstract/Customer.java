package _2_abstract;

public abstract class Customer {

    abstract public int customerNumber( );

    public int total() {
        switch ( customerNumber() ) {
            case 100:
                return 10000;
            case 200:
                return 2000;
            default:
                return 0;
        }
    }



}
