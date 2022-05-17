
import java.util.TimerTask;

public class screenUpdateTask extends TimerTask {
    Frame myFrame;
    public screenUpdateTask(Frame myFrame){
        super();
        this.myFrame = myFrame;
    }
    @Override
    public void run() {
        myFrame.tacoCountUpdate(5);
    }
}
