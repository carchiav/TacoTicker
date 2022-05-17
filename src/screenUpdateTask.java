import java.util.TimerTask;

public class screenUpdateTask extends TimerTask {
    Panel panel1;
    screenUpdateTask(Panel panel){
        super();
        panel1 = panel;
    }
    @Override
    public void run() {
        //panel1.update();
    }
}
