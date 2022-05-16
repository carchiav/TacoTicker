public class Producer {
    private int cost;
    private int TPS;

    public Producer(int cost, int TPS) {
        this.cost = cost;
        this.TPS = TPS;
    }

    public int getTPS() {
        return TPS;
    }

    public int getCost() {
        return cost;
    }

    public int producerIndex() {
        return -1;
    }
}
