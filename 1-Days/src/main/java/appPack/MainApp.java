package appPack;

import _1_inheritance.A;
import _1_inheritance.B;
import _1_inheritance.Base;
import _1_inheritance.C;

public class MainApp {

    public static void main(String[] args) {

        A nsa = new A();
        B nsb = new B();
        C nsc = new C();

        mainCall(nsa);
        mainCall(nsb);
        mainCall(nsc);

    }

    public static void mainCall(Base base) {
        if ( base instanceof A ) {
            A nsa = (A) base;
            nsa.sum(30,50);
        }
        base.action();
    }


}
