package xmlparser.timer;

public class Timer {

    public void timer(int number){
        while (number > 0){
            System.out.println(number);
            number--;
            try{
                Thread.sleep(1000);
            } catch (Exception ex){
                System.out.println("Runnable Error: " + ex);
            }
        }
    }

}
