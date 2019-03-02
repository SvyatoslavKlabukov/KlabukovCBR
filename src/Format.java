public enum Format {
    A5(0),
    A4(1),
    A3(2);
    private int value;

    Format(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
};

