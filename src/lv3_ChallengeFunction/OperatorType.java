package lv3_ChallengeFunction;

public enum OperatorType {
    ADDITION("+"), SUBSTRACTION("-"), MULTIPLICATION("*"), DIVISITON("/"), SQUARE("^"), SQUARE_ROOT("√");

    private final String label;

    OperatorType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean containsOfLabel(String operator) {
        for (OperatorType opt : OperatorType.values()){
            if (operator.equals(opt.getLabel())) {
                return true;
            }
        }
        return false;
    }
}
