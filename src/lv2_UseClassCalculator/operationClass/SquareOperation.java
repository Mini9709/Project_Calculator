package lv2_UseClassCalculator.operationClass;

public class SquareOperation extends AbstractMonomialOperation{

    public double operate(Number firstNumber){
        return firstNumber.doubleValue() * firstNumber.doubleValue();
    }
}
