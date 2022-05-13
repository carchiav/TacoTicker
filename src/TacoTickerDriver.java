public class TacoTickerDriver {
    public static void main(String[] args){
        Player Player1 = new Player();
        gameLoop(Player1);
    }
    public static void gameLoop(Player p){
        java.util.TimerTask gameTask = new java.util.TimerTask()
        {
            @Override
            public void run() {
                p.calcTPS();
                System.out.println(p.getTPS());
            }
        };
        new java.util.Timer().schedule(gameTask,5000);
    }
}
