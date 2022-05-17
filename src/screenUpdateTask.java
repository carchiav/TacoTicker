
import java.util.TimerTask;

public class screenUpdateTask extends TimerTask {
    Frame myFrame;
    Player player1;
    public screenUpdateTask(Frame myFrame,Player player1){
        super();
        this.myFrame = myFrame;
        this.player1 = player1;
    }
    @Override
    public void run() {
        myFrame.tacoCountUpdate(player1.getTacoCount());
    }
}
