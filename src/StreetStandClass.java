public class StreetStandClass extends Producer {
    static int thisTPS = 1;

    public StreetStandClass(long c) {
        super(c, 1);
    }

    public int producerIndex() {
        return 0;
    }
}