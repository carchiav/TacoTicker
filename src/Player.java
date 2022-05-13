import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Player {
    private int tacoCount;
    private int tacosPerTick;
    private int TPS;

    private int[] producerCounts;
    private ArrayList<Producer> producers;
    private int[] producerCosts;
    private int[] upgrades;


    public Player(){

    }
    public void calcTPS(){
        int temp = 0;
        /*for (Producer i : producers){
            temp += i.getTPS();
        }*/
        temp = 5;
        TPS = temp;
        System.out.println(temp);
    }
    public int getTPS(){
        return TPS;
    }


    public void removeTacos(int i){
        tacoCount -= i;
    }
    public void addTacos(int i){
        tacoCount += i;
    }
    public void saveGame() {
        File saveFile = new File("SaveData.txt");
        try {
            FileWriter writer = new FileWriter("SaveData.txt");
            writer.write(tacoCount + "|" + tacosPerTick + "|" + TPS + "|" + producerCounts.toString()+"|" + upgrades.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("error");
        }
    }
        public void loadGame(){
        try {
            File save = new File("saveData.txt");
            Scanner input = new Scanner(save);
            String curr = input.nextLine();
            tacoCount = Integer.parseInt(curr);

            }
        catch(FileNotFoundException e){
            tacoCount = 0;
            tacosPerTick = 1;
            TPS = 0;
            producerCounts = new int[7];
            upgrades = new int[9];
            producers = new ArrayList<Producer>();
        }
    }

}
