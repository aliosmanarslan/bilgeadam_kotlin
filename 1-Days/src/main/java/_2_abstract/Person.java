package _2_abstract;

public class Person extends Customer{

    int cNumber = 0;
    public Person( int cNumber ) {
        this.cNumber = cNumber;
    }

    @Override
    public int customerNumber() {
        return this.cNumber;
    }

}
