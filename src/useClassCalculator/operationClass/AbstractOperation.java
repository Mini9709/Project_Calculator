package useClassCalculator.operationClass;

import useClassCalculator.exceptionClass.BadOperationException;

public abstract class AbstractOperation {

    public abstract double operate(int firstNumber, int secondNumber) throws BadOperationException;
}
