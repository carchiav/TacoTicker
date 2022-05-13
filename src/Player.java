import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
    private boolean[] upgrades;


    public Player(){
        //loadGame();
        producerCounts = new int[]{1, 1, 1, 1, 1, 1, 1};
        upgrades = new boolean[]{true, false, true, true,false,true,false};
        producerCosts = new int[]{20,120,800,5000,2500,200000,1000000};
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
            writer.write(tacoCount + "|" + tacosPerTick + "|" + TPS + "|" + Arrays.toString(producerCounts) +"|" + Arrays.toString(upgrades));
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
            int currMarker = 0;
            int nextMarker = 0;
            int counter = 1;

            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) == '|') {
                    nextMarker = i;
                    if (counter == 1)
                        tacoCount = Integer.parseInt(curr.substring(0, nextMarker));
                    else if (counter == 2)
                        tacosPerTick = Integer.parseInt(curr.substring(currMarker, nextMarker));
                    else if (counter == 3)
                        TPS = Integer.parseInt(curr.substring(currMarker, nextMarker));
                    /*else if (counter == 4)
                        String prodTemp = Integer.parseInt(curr.substring(0, nextMarker));
                    else if (counter == 5)
                        String upTemp = curr.substring(0, nextMarker);*/
                    currMarker = nextMarker+1;
                    counter++;
                }



            }
        }
        catch(FileNotFoundException e){
            tacoCount = 0;
            tacosPerTick = 1;
            TPS = 0;
            producerCounts = new int[7];
            upgrades = new boolean[9];
            producers = new ArrayList<Producer>();
        }
    }

}
