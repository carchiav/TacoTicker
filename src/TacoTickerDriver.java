import java.util.Timer;
public class TacoTickerDriver {
    public static void main(String[] args){
        Player Player1 = new Player();
        Player1.saveGame();
        gameLoop(Player1);
    }
    public static void gameLoop(Player p){
         gameTimer gameTask = new gameTimer(p);
         new Timer().schedule(gameTask,0,100);
    }
}
