package useClassCalculator.operationClass;

public class AddOperation extends AbstractOperation {

    @Override
    public double operate(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
}
