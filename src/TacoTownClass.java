public class TacoTownClass extends Producer {
    static int thisTPS = 8000;
    public TacoTownClass(int c) {
        super(c, 8000);
    }

    public int producerIndex() {
        return 5;
    }

}
