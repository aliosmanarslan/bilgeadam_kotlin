package util;

public class Control {

    public boolean control(String data){
        try {
            Integer.parseInt(data);
            return true;
        } catch (Exception ex){
            return false;
        }
    }
}
