import java.util.Timer;
public class TacoTickerDriver {
    public static void main(String[] args){
        Player player1 = new Player();
        player1.loadGame();
        Frame myFrame = new Frame();
        player1.printPlayerInfo();
        gameLoop(player1, myFrame);
    }
    public static void gameLoop(Player p, Frame myFrame){
         screenUpdateTask screenUpdateTask1 = new screenUpdateTask(myFrame,p);
         new Timer().schedule(screenUpdateTask1,0,30);
         TPSTask TPSTask1 = new TPSTask(p);
         new Timer().schedule(TPSTask1,0,1000);
    }
}

