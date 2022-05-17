import java.util.Timer;
public class TacoTickerDriver {
    public static void main(String[] args){
        Player player1 = new Player();
        player1.loadGame();
        player1.printPlayerInfo();
        //gameLoop(player1);
    }
    public static void gameLoop(Player p){
         //screenUpdateTask screenUpdateTask1 = new screenUpdateTask(panel);
         //new Timer().schedule(screenUpdateTask1,0,100);
         TPSTask TPSTask1 = new TPSTask(p);
         new Timer().schedule(TPSTask1,0,100);
    }
}

