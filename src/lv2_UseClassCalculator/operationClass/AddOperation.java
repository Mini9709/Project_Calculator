package lv2_UseClassCalculator.operationClass;

import lv2_UseClassCalculator.exceptionClass.BadOperationException;

public class AddOperation extends AbstractOperation {

    @Override
    public double operate(Number firstNumber, Number secondNumber){
        return firstNumber.doubleValue() + secondNumber.doubleValue();
    }
}
