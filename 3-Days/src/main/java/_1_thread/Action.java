package _1_thread;

public class Action implements Runnable  {

    String path = "";
    public Action( String path ) {
        this.path = path;
    }

    @Override
    public void run() {
        // Thread Başladığında çalışacak gövde
        // Gecikme ihtimali olan kodların yazıldığı yer

        boolean status = false;
        for ( int i = 0; i < 10; i++ ) {
            System.out.println("for call - " + path);
            try {
                Thread.sleep(1000);
            }catch (Exception ex) { }

            if (status) break;
        }

    }

}
