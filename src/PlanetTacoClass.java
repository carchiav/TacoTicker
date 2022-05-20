public class PlanetTacoClass extends Producer {
    static int thisTPS = 40000;
    public PlanetTacoClass(long c) {
        super(c, 40000);
    }

    public int producerIndex() {
        return 6;
    }

}
