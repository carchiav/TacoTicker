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
        String ach = player1.achievementsCheck();
        if (ach != null)
            System.out.println(ach);
        player1.saveGame();
    }
}
