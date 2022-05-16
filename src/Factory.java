public class Factory extends Producer {

    public Factory(int c) {
        super(c, 200);
    }

    public int producerIndex() {
        return 3;
    }

}

