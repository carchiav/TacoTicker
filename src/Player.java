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
    private long[] producerCosts;
    private boolean[] upgrades;
    private boolean[] achievements;
    private int totalTicks;

    public static Player thisPlayer;

                                                                            //constructor
    public Player() {
        tacoCount = 0;
        producers = new ArrayList<Producer>();
        producerCounts = new int[] {0, 0, 0, 0, 0, 0, 0};
        producerCosts = new long[] {25, 180, 1500, 10000, 85000, 1000000, 10000000};
        upgrades = new boolean[] {false, false, false, false, false, false, false, false, false};
        achievements = new boolean[18];
        for (int i = 0 ; i < achievements.length ; i++)
            achievements[i] = false;
        totalTicks = 0;
        thisPlayer = this;
    }

                                                                            //getters
    public long getTacoCount() {
        return tacoCount;
    }
    public long getCost(int i) {
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
    public void addToTotalTicks() {
        totalTicks++;
    }

                                                                            //methods for testing
    public void printProducerCounts() {
        System.out.println("");
        for (int i : producerCounts)
            System.out.print(i + ", ");
    }
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
    }

                                                                            //useful logic methods
    public boolean buy(Producer p) {
        if (tacoCount < p.getCost())
            return false;
        else {
            tacoCount -= p.getCost();
            producers.add(p);
            producerCounts[p.producerIndex()]++;
            producerCosts[p.producerIndex()] = (long)(p.getCost()*1.2);
            return true;
        }
    }
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
    public String achievementsCheck() {
        if (producerCounts[0] != 0 && !achievements[0]) {
            achievements[0] = true;
            return "Welcome to TacoTicker: Buy a Street Stand";
        }
        if (producerCounts[1] != 0 && !achievements[1]) {
            achievements[1] = true;
            return "Ramping up Production: Buy a Taco Shop";
        }
        if (producerCounts[2] != 0 && !achievements[2]) {
            achievements[2] = true;
            return "Franchiser: Buy a Restaurant";
        }
        if (producerCounts[3] != 0 && !achievements[3]) {
            achievements[3] = true;
            return "Industrial Revolution: Buy a Factory";
        }
        if (producerCounts[4] != 0 && !achievements[4]) {
            achievements[4] = true;
            return "Horizon-taco-l Integration: Buy a Conglomerate";
        }
        if (producerCounts[5] != 0 && !achievements[5]) {
            achievements[5] = true;
            return "Won't You Take Me: Buy a Taco Town";
        }
        if (producerCounts[6] != 0 && !achievements[6]) {
            achievements[6] = true;
            return "Bring Me To Your Tortilla: Buy a Planet Taco";
        }
        if (producerCounts[0] >= 100 && !achievements[7]) {
            achievements[7] = true;
            return "Return Customer: Buy 100 Street Stands";
        }
        if (producerCounts[1] >= 100 && !achievements[8]) {
            achievements[8] = true;
            return "Average Taco Enjoyer: Buy 100 Taco Shops";
        }
        if (producerCounts[2] >= 100 && !achievements[9]) {
            achievements[9] = true;
            return "I'll have my usual, please: Buy 100 Restaurants";
        }
        if (producerCounts[3] >= 100 && !achievements[10]) {
            achievements[10] = true;
            return "Economies of Scale: Buy 100 Factories";
        }
        if (producerCounts[4] >= 100 && !achievements[11]) {
            achievements[11] = true;
            return "Elon: Buy 100 Conglomerates";
        }
        if (producerCounts[5] >= 100 && !achievements[12]) {
            achievements[12] = true;
            return "Did you know that the name of this producer was inspired by an SNL sketch with Bill Hader and Andy Samberg?: Buy 100 Taco Towns";
        }
        if (producerCounts[6] >= 100 && !achievements[13]) {
            achievements[13] = true;
            return "I don't believe that you got this achievement legitimately: Buy 100 Planet Tacos";
        }
        if (totalTicks >= 1000 && !achievements[14]) {
            achievements[14] = true;
            return "Carpal Tunnel: Click 1000 times";
        }
        if (!achievements[15]) {
            boolean failCondition = false;
            for (int i = 0 ; i < upgrades.length ; i++)
                if (!upgrades[i])
                    failCondition = true;
            if (!failCondition) {
                achievements[15] = true;
                return "Efficiency Expert: Buy every upgrade";
            }
        }
        if (!achievements[16]) {
            boolean failCondition = false;
            for (int i = 0 ; i < producerCounts.length ; i++)
                if (producerCounts[i] == 0)
                    failCondition = true;
            for (int i = 0 ; i < upgrades.length ; i++)
                if (!upgrades[i])
                    failCondition = true;
            if (!failCondition) {
                achievements[16] = true;
                return "Completionist: Buy EVERYTHING";
            }
        }
        if (!achievements[17] && tacoCount == 1000000000) {
            achievements[17] = true;
            return "Nice Round Number: Get exactly 1,000,000,000 tacos";
        }
        return null;
    }
                                                                            //upgrade buy methods
    public boolean buyMegaphone() {
        if (tacoCount < 200)
            return false;
        else {
            tacoCount -= 200;
            upgrades[0] = true;
            return true;
        }
    }
    public boolean buyTortillaPress() {
        if (tacoCount < 1600)
            return false;
        else {
            tacoCount -= 1600;
            upgrades[1] = true;
            return true;
        }
    }
    public boolean buyHotSauce() {
        if (tacoCount < 18000)
            return false;
        else {
            tacoCount -= 18000;
            upgrades[2] = true;
            return true;
        }
    }
    public boolean buyAssemblyLine() {
        if (tacoCount < 200000)
            return false;
        else {
            tacoCount -= 200000;
            upgrades[3] = true;
            return true;
        }
    }
    public boolean buyBoardroom() {
        if (tacoCount < 1200000)
            return false;
        else {
            tacoCount -= 1200000;
            upgrades[4] = true;
            return true;
        }
    }
    public boolean buyConstitution() {
        if (tacoCount < 15000000)
            return false;
        else {
            tacoCount -= 15000000;
            upgrades[5] = true;
            return true;
        }
    }
    public boolean buyLettuceLand() {
        if (tacoCount < 300000000)
            return false;
        else {
            tacoCount -= 300000000;
            upgrades[6] = true;
            return true;
        }
    }
    public boolean buyBell() {
        long bellCost =(100000 + 300*calcTPS());
        if (tacoCount < bellCost)
            return false;
        else {
            tacoCount -= bellCost;
            upgrades[7] = true;
            return true;
        }
    }
    public boolean buyTacoMakingGloves() {
        long glovesCost = 10000 + 100*calcTPS();
        if (tacoCount < glovesCost)
            return false;
        else {
            tacoCount -= glovesCost;
            upgrades[8] = true;
            return true;
        }
    }


                                                                            //save and load methods
    public void saveGame() {
        File saveFile = new File("SaveData.txt");
        try {
            FileWriter writer = new FileWriter("SaveData.txt");
            writer.write(tacoCount + "|" + Arrays.toString(producerCounts) +"|" + Arrays.toString(upgrades)+"|");
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
                        upgrades[8] = Boolean.parseBoolean((upTemp.substring(currComma, upTemp.length() - 1)).replaceAll("\\s", ""));

                    }
                    currMarker = nextMarker+1;
                    counter++;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
            tacoCount = 0;
            producerCounts = new int[7];
            upgrades = new boolean[9];
            producers = new ArrayList<Producer>();

        }

        //Initialize all Producers from Save:
        for (int i = 0; i<7;i++) {
            for (int j = 0; j < producerCounts[i]; j++) {
                if (i == 0) {
                    producers.add(new StreetStandClass(getCost(0)));
                    producerCosts[0] = (long)(getCost(0)*1.2);
                }
                if (i == 1)  {
                    producers.add(new TacoShopClass(getCost(1)));
                    producerCosts[1] = (long)(getCost(1)*1.2);
                }
                if (i == 2)  {
                    producers.add(new RestaurantClass(getCost(2)));
                    producerCosts[2] = (long)(getCost(2)*1.2);
                }
                if (i == 3)  {
                    producers.add(new FactoryClass(getCost(3)));
                    producerCosts[3] = (long)(getCost(3)*1.2);
                }
                if (i == 4)  {
                    producers.add(new ConglomerateClass(getCost(4)));
                    producerCosts[4] = (long)(getCost(4)*1.2);
                }
                if (i == 5)  {
                    producers.add(new TacoTownClass(getCost(5)));
                    producerCosts[5] = (long)(getCost(5)*1.2);
                }
                if (i == 6)  {
                    producers.add(new PlanetTacoClass(getCost(6)));
                    producerCosts[6] = (long)(getCost(6)*1.2);
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
