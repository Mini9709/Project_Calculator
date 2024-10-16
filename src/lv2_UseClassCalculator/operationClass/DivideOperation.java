package lv2_UseClassCalculator.operationClass;

import lv2_UseClassCalculator.exceptionClass.BadOperationException;

public class DivideOperation extends AbstractOperation{

    @Override
    public double operate(Number firstNumber, Number secondNumber) throws BadOperationException {
        if (secondNumber.doubleValue() == 0) {
            throw new BadOperationException();
        }
        return firstNumber.doubleValue() / secondNumber.doubleValue();
    }
}
