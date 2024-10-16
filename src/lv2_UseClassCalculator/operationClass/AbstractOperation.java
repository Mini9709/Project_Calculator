package lv2_UseClassCalculator.operationClass;

import lv2_UseClassCalculator.exceptionClass.BadOperationException;

public abstract class AbstractOperation<T extends Number> {

    public abstract double operate(T firstNumber, T secondNumber) throws BadOperationException;
}
