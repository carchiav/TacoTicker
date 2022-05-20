public class Producer {
    private long cost;
    private int TPS;

    public Producer(long cost, int TPS) {
        this.cost = cost;
        this.TPS = TPS;
    }

    public int getTPS() {
        return TPS;
    }

    public long getCost() {
        return cost;
    }

    public int producerIndex() {
        return -1;
    }
}
