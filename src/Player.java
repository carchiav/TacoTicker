import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Player {
    private long tacoCount;

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
    public int calcTPS(){
        int temp = 0;
        /*for (Producer i : producers){
            temp += i.getTPS();
        }*/
        temp = 5;
        return temp;
    }


    public void removeTacos(int i){
        tacoCount -= i;
    }
    public void addTacos(int i){
        tacoCount += i;
    }
    public Long getTacoCount(){return tacoCount;}
    public void saveGame() {
        File saveFile = new File("SaveData.txt");
        try {
            FileWriter writer = new FileWriter("SaveData.txt");
            writer.write(tacoCount + "|" + getTacoPerTick() + "|" + Arrays.toString(producerCounts) +"|" + Arrays.toString(upgrades)+"|");
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
                    if (counter == 1) tacoCount = Long.parseLong(curr.substring(currMarker, nextMarker));
                    else if (counter == 2) tacosPerTick = Integer.parseInt(curr.substring(currMarker, nextMarker));
                    else if (counter == 3) {
                        int counter2 = 0;
                        int currComma = 1;
                        int nextComma = 1;
                        String prodTemp = curr.substring(currMarker, nextMarker);
                        for (int j = 0; j < prodTemp.length()-1; j++) {
                            if (prodTemp.charAt(j) == ',') {
                                nextComma = j;
                                producerCounts[counter2] = Integer.parseInt(prodTemp.substring(currComma, nextComma).replaceAll("\\s", ""));
                                counter2++;
                                currComma = nextComma+1;
                            }
                        }
                        producerCounts[6] = Integer.parseInt(prodTemp.substring(currComma, prodTemp.length()-1).replaceAll("\\s", ""));

                    }
                    else if (counter == 4) {
                        int counter2 = 0;
                        int currComma = 1;
                        int nextComma = 1;
                        String upTemp = curr.substring(currMarker, nextMarker);
                        for (int j = 0; j < upTemp.length()-1; j++) {
                            if (upTemp.charAt(j) == ',') {
                                nextComma = j;
                                upgrades[counter2] = Boolean.parseBoolean(upTemp.substring(currComma, nextComma).replaceAll("\\s", ""));
                                counter2++;
                                currComma = nextComma+1;
                            }
                        }
                        upgrades[6] = Boolean.parseBoolean(upTemp.substring(currComma, upTemp.length() - 1).replaceAll("\\s", ""));

                    }
                    currMarker = nextMarker+1;
                    counter++;
                }
            }
        }
        catch(FileNotFoundException e){
            tacoCount = 0;
            tacosPerTick = 1;
            producerCounts = new int[7];
            upgrades = new boolean[9];
            producers = new ArrayList<Producer>();

        }
    }

}
