import java.util.TimerTask;

public class TPSTimer extends TimerTask {
    Player player1;
    public TPSTimer(Player player){
        super();
        player1 = player;
    }
    @Override
    public void run() {
        player1.addTacos(player1.calcTPS());
    }
}
