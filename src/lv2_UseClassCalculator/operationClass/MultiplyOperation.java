package lv2_UseClassCalculator.operationClass;

public class MultiplyOperation extends AbstractOperation {

    @Override
    public double operate(int firstNumber, int secondNumber){
        return firstNumber * secondNumber;
    }
}
