public class RestaurantClass extends Producer {
    static int thisTPS = 40;
    public RestaurantClass(long c) {
        super(c, 40);
    }

    public int producerIndex() {
        return 2;
    }

}
