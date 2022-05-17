import java.util.Timer;
public class TacoTickerDriver {
    public static void main(String[] args){
        Player player1 = new Player();
        player1.loadGame();
        System.out.println(player1.getTacoCount());
        gameLoop(player1);
    }
   public static void gameLoop(Player p){
         screenUpdateTimer gameTask = new screenUpdateTimer(p);
         new Timer().schedule(gameTask,0,30);
        }
    }

