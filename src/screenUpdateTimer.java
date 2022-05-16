import java.util.TimerTask;

public class screenUpdateTimer extends TimerTask {
    Panel panel1;
    screenUpdateTimer(Panel panel){
        super();
        panel1 = panel;
    }
    @Override
    public void run() {
        //panel1.update();
    }
}
