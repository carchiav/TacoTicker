public class TacoShopClass extends Producer {
    static int thisTPS = 5;
    public TacoShopClass(int c) {
        super(c, 5);
    }

    public int producerIndex() {
        return 1;
    }
}

