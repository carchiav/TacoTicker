public class RestaurantClass extends Producer {
    static int thisTPS = 40;
    public RestaurantClass(int c) {
        super(c, 40);
    }

    public int producerIndex() {
        return 2;
    }

}
