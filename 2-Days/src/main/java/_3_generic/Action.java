package _3_generic;

import java.util.ArrayList;
import java.util.List;

public class Action<T> implements IAction<T> {

    List<T> list = new ArrayList<>();

    int size ( T t ) {
        if ( t instanceof String ) {
            return t.toString().length();
        }
        return 0;
    }

    @Override
    public boolean add(T t) {
        return list.add(t);
    }

}
