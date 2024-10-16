package lv2_UseClassCalculator.operationClass;

import lv2_UseClassCalculator.exceptionClass.BadOperationException;

public abstract class AbstractOperation {

    public abstract double operate(int firstNumber, int secondNumber) throws BadOperationException;
}
