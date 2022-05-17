import java.util.TimerTask;

public class TPSTask extends TimerTask {
    Player player1;
    public TPSTask(Player player){
        super();
        player1 = player;
    }
    @Override
    public void run() {
        player1.addTacos(player1.calcTPS());
    }
}
