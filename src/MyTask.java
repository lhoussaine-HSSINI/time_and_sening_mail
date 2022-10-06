import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask {
    public static int count=0;
    public void run() {
        System.out.println("Task is running");
        count+=1;
        if (count == 2) {
            Main.timer.cancel();
            Main.timer.purge();
        }
    }
}