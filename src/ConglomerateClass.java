public class ConglomerateClass extends Producer {
    static int thisTPS = 1200;
    public ConglomerateClass(long c) {
        super(c, 1200);
    }

    public int producerIndex() {
        return 4;
    }

}
