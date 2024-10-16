package lv3_ChallengeFunction;

public enum NumberType {
    ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"),
    SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), ZERO("0");

    private final String label;

    NumberType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean containsOfLabel(String number) {
        for (NumberType nbt : NumberType.values()) {
            if (number.equals(nbt.getLabel())) {
                return true;
            }
        }
        return false;
    }
}
