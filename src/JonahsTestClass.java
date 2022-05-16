import java.util.*;
public class JonahsTestClass {

    static int TPS = 0;
    static int totalTacos = 0;
    static ArrayList<Producer> Producers = new ArrayList<Producer>();
    static int[] ProducerCounts = {0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        System.out.println(TPS);

        Producers.add(new StreetStand());

        System.out.println(TPS);
    }

    public static int calcTPS() {
        int total = 0;
        for (Producer p : Producers)
            total += p.getTPS();
        return total;
    }

}
