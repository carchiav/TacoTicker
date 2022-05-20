public class FactoryClass extends Producer {
    static int thisTPS = 200;
    public FactoryClass(long c) {
        super(c, 200);
    }

    public int producerIndex() {
        return 3;
    }

}

