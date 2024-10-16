package lv2_UseClassCalculator.operationClass;

import lv2_UseClassCalculator.exceptionClass.BadOperationException;

public class DivideOperation extends AbstractOperation{

    @Override
    public double operate(int firstNumber, int secondNumber) throws BadOperationException {
        if (secondNumber == 0) {
            throw new BadOperationException();
        }
        return (double) firstNumber / secondNumber;
    }
}
