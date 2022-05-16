import java.util.TimerTask;

public class gameTimer extends TimerTask {
    Player player1;
    Panel panel1;
    public gameTimer(Player player){
        super();
        player1 = player;
    }
    public gameTimer(Player player, Panel panel){
        super();
        player1 = player;
        panel1 = panel;
    }
    @Override
    public void run() {

        player1.calcTPS();
        player1.addTacos(player1.calcTPS());
        //panel1.update();
    }
}
