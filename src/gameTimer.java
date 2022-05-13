import java.util.TimerTask;

public class gameTimer extends TimerTask {
    Player p;
    public gameTimer(Player p){
        super();
        this.p=p;
    }
    @Override
    public void run() {

        p.calcTPS();
        System.out.println(p.getTPS());
        //Graphics.updateDisplay();
    }
}
