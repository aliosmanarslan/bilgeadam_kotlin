package appPack;

import _1_thread.Action;

import java.util.Timer;
import java.util.TimerTask;

public class MainApp {

    static Timer timer = new Timer();

    public static void main(String[] args) {


        Action ac1 = new Action("Image-1");
        Action ac2 = new Action("Image-2");
        Action ac3 = new Action("Image-3");
        Action ac4 = new Action("Image-4");
        Action ac5 = new Action("Image-5");

        Thread th1 = new Thread(ac1);
        Thread th2 = new Thread(ac2);
        Thread th3 = new Thread(ac3);
        Thread th4 = new Thread(ac4);
        Thread th5 = new Thread(ac5);

        // Java 8 new Thread with Lambda
        Runnable rn = () -> {
            try {

                th1.start();
                th1.join();

                th2.start();
                th2.join();

                th3.start();
                th3.join();

                th4.start();
                th4.join();

                th5.start();
                th5.join();

            }catch (Exception ex) {};
        };
        new Thread(rn).start();

        System.out.println("Main App call");

        MainApp app = new MainApp();

        timer.schedule(app.task, 0, 3000);
        // timer.cancel();
    }


    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            System.out.println("Run Call");

        }
    };

}
