public class Restaurant extends Producer {

    public Restaurant(int c) {
        super(c, 40);
    }

    public int producerIndex() {
        return 2;
    }

}
