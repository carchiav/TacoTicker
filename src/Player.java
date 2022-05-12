import java.util.ArrayList;
public class Player {
    int tacoCount;
    int tacosPerTick;
    int TPS;

    int[] producerCounts;
    ArrayList<Producer> producers;
    int[] upgrades;

    public Player(){
        public void loadGame();
    }
    public void calcTPS(){
        int temp = 0;
        for (Producer i : producers){
            temp += i.getTPS();
        }
        TPS = temp;
    }
    public void calcTPSLoop() throws InterruptedException {
        int i = 0;
        do{
            calcTPS();
            Thread.sleep(1000);
        }while(i!=1);

    }
    public void removeTacos(int i){

    }
    public void addTacos(int i){

    }
    public void saveGame(){

    }
    public void loadGame(){
        tacoCount = 0;
        tacosPerTick = 1;
        TPS = 0;
        producerCounts = new int[7];
        upgrades = new int[9];
        producers = new ArrayList<Producer>();
    }

}
