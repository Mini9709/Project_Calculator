package lv2_UseClassCalculator.operationClass;


public class SquareRootOperation extends AbstractMonomialOperation{

    public double operate(Number firstNumber) {
        return Math.sqrt(firstNumber.doubleValue());
    }
}
