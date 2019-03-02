public enum DocumentType {
    LETTER(0),
    ESSEY(1),
    PRESENTATION(2);

    private int value;

    DocumentType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
};
