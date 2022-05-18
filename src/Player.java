import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Player {

    private long tacoCount;
    private ArrayList<Producer> producers;
    private int[] producerCounts;
    private int[] producerCosts;
    private boolean[] upgrades;

    public static Player thisPlayer;

    public Player() {                                                                             //constructor
        tacoCount = 0;
        producers = new ArrayList<Producer>();
        producerCounts = new int[] {0, 0, 0, 0, 0, 0, 0};
        producerCosts = new int[] {20, 120, 800, 5000, 25000, 200000, 1000000};
        upgrades = new boolean[] {false, false, false, false, false, false, false, false, false};
        thisPlayer = this;
    }

    public long getTacoCount() {
        return tacoCount;
    }                   //getters
    public int getCost(int i) {
        return producerCosts[i];
    }
    public int getProducerAmount(int i)  {
        return producerCounts[i];
    }
    public boolean getUpgrade(int i) {
        return upgrades[i];
    }
    public int getTacosPerTick() {
        if (upgrades[8])
            return (int)(calcTPS()*0.05);
        else
            return 1;
    }

    public void printProducerCounts() {
        System.out.println("");
        for (int i : producerCounts)
            System.out.print(i + ", ");
    }                   //methods for testing
    public void iterateTPS() {
        addTacos(calcTPS());
    }
    public void printPlayerInfo() {

        System.out.println(  "Taco Count: " + getTacoCount() + "\n" +
                "Tacos Per Second: " + calcTPS() +
                "Tacos Per Tick : " + getTacosPerTick() +
                "\n\nBuildings: " +
                "\nStreet Stands/Cost: " + getProducerAmount(0) + " " + getCost(0) +
                "\nTaco Shops/Cost: " + getProducerAmount(1) + " " + getCost(1) +
                "\nRestaurants/Cost: " + getProducerAmount(2) + " " + getCost(2) +
                "\nFactories/Cost: " + getProducerAmount(3) + " " + getCost(3) +
                "\nConglomerates/Cost: " + getProducerAmount(4) + " " + getCost(4) +
                "\nTaco Towns/Cost: " + getProducerAmount(5) + " " + getCost(5) +
                "\nPlanet Tacos/Cost: " + getProducerAmount(6) + " " + getCost(6) +
                "\n\nUpgrade: Megaphone = " + getUpgrade(0) +
                "\nUpgrade: Tortilla Press = " + getUpgrade(1) +
                "\nUpgrade: Hot Sauce = " + getUpgrade(2) +
                "\nUpgrade: Assembly Line = " + getUpgrade(3) +
                "\nUpgrade: Boardroom = " + getUpgrade(4) +
                "\nUpgrade: Constitution = " + getUpgrade(5) +
                "\nUpgrade: Lettuce Land = " + getUpgrade(6) +
                "\nUpgrade: Bell = " + getUpgrade(7) +
                "\nUpgrade: Taco Making Gloves = " + getUpgrade(8) );
    }//for testing


    public boolean buy(Producer p) {
        if (tacoCount < p.getCost())
            return false;
        else {
            tacoCount -= p.getCost();
            producers.add(p);
            producerCounts[p.producerIndex()]++;
            producerCosts[p.producerIndex()] = (int)(p.getCost()*1.2);
            return true;
        }
    }          //actually useful methods
    public long calcTPS() {
        long total = 0;
        for (Producer p : producers) {
            if (upgrades[p.producerIndex()])
                total += 2L * p.getTPS();
            else
                total += p.getTPS();
        }
        if (upgrades[7])
            total = 2 * total;
        return total;
    }
    public void addTacos(long i) {
        tacoCount += i;
    }

    public boolean buyMegaphone() {
        if (tacoCount < 200)
            return false;
        else {
            tacoCount -= 200;
            upgrades[0] = true;
            return true;
        }
    }          //upgrade buy methods
    public boolean buyTortillaPress() {
        if (tacoCount < 1000)
            return false;
        else {
            tacoCount -= 1000;
            upgrades[1] = true;
            return true;
        }
    }
    public boolean buyHotSauce() {
        if (tacoCount < 10000)
            return false;
        else {
            tacoCount -= 10000;
            upgrades[2] = true;
            return true;
        }
    }
    public boolean buyAssemblyLine() {
        if (tacoCount < 75000)
            return false;
        else {
            tacoCount -= 75000;
            upgrades[3] = true;
            return true;
        }
    }
    public boolean buyBoardroom() {
        if (tacoCount < 500000)
            return false;
        else {
            tacoCount -= 500000;
            upgrades[4] = true;
            return true;
        }
    }
    public boolean buyConstitution() {
        if (tacoCount < 10000000)
            return false;
        else {
            tacoCount -= 10000000;
            upgrades[5] = true;
            return true;
        }
    }
    public boolean buyLettuceLand() {
        if (tacoCount < 200000000)
            return false;
        else {
            tacoCount -= 200000000;
            upgrades[6] = true;
            return true;
        }
    }
    public boolean buyBell() {
        long bellCost = 10000 + 600*calcTPS();
        if (tacoCount < bellCost)
            return false;
        else {
            tacoCount -= bellCost;
            upgrades[7] = true;
            return true;
        }
    }
    public boolean buyTacoMakingGloves() {
        long glovesCost = 1000 + 300*calcTPS();
        if (tacoCount < glovesCost)
            return false;
        else {
            tacoCount -= glovesCost;
            upgrades[8] = true;
            return true;
        }
    }



    public void saveGame() {
        File saveFile = new File("SaveData.txt");
        try {
            FileWriter writer = new FileWriter("SaveData.txt");
            writer.write(tacoCount + "|" + Arrays.toString(producerCounts) +"|" + Arrays.toString(upgrades)+"|");
            writer.close();
        } catch (IOException e) {
            System.out.println("error");
        }
    }  //dont touch these
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
                    else if (counter == 2) {
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
                    else if (counter == 3) {
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
            producerCounts = new int[7];
            upgrades = new boolean[9];
            producers = new ArrayList<Producer>();

        }
        //Initialize all upgrades from save:
        /*for (int i = 0; i<upgrades.length;i++){

        }*/
        //Initialize all Producers from Save:
        for (int i = 0; i<7;i++) {
            for (int j = 0; j < producerCounts[i]; j++) {
                if (i == 0) {
                    producers.add(new StreetStand(getCost(0)));
                    producerCosts[0] = (int)(getCost(0)*1.2);
                }
                if (i == 1)  {
                    producers.add(new TacoShop(getCost(1)));
                    producerCosts[1] = (int)(getCost(1)*1.2);
                }
                if (i == 2)  {
                    producers.add(new Restaurant(getCost(2)));
                    producerCosts[2] = (int)(getCost(2)*1.2);
                }
                if (i == 3)  {
                    producers.add(new Factory(getCost(3)));
                    producerCosts[3] = (int)(getCost(3)*1.2);
                }
                if (i == 4)  {
                    producers.add(new Conglomerate(getCost(4)));
                    producerCosts[4] = (int)(getCost(4)*1.2);
                }
                if (i == 5)  {
                    producers.add(new TacoTown(getCost(5)));
                    producerCosts[5] = (int)(getCost(5)*1.2);
                }
                if (i == 6)  {
                    producers.add(new PlanetTaco(getCost(6)));
                    producerCosts[6] = (int)(getCost(6)*1.2);
                }
            }
        }
    }

}

/*
    REFERENCE BUY LINES TO COPY/PASTE


p.buy(new StreetStand(p.getCost(0)));

p.buy(new TacoShop(p.getCost(1)));

p.buy(new Restaurant(p.getCost(2)));

p.buy(new Factory(p.getCost(3)));

p.buy(new Conglomerate(p.getCost(4)));

p.buy(new TacoTown(p.getCost(5)));

p.buy(new PlanetTaco(p.getCost(6)));
 */
