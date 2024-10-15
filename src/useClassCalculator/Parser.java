package useClassCalculator;

import useClassCalculator.exceptionClass.BadInputException;
import useClassCalculator.operationClass.*;

public class Parser {
    private static final String OPERATION_REG = "[+\\-*/√^]";
    private static final String NUMBER_REG = "^[0-9]*$";
    private static boolean monomial = false; // 단항식인지 확인하는 boolean값

    private final Calculator calculator = new Calculator();

    public boolean getMonomial() {
        return monomial;
    }

    public void parseFirstNum(String firstInput) throws BadInputException {
        // 구현 1.
        if(!firstInput.matches(NUMBER_REG)) {
            throw new BadInputException("숫자");
        }

        calculator.setFirstNumber(Integer.parseInt(firstInput));
    }

    public void parseSecondNum(String secondInput) throws BadInputException {
        // 구현 1.
        if(!secondInput.matches(NUMBER_REG)) {
            throw new BadInputException("숫자");
        }

        calculator.setSecondNumber(Integer.parseInt(secondInput));
    }

    public void parseOperator(String operationInput) throws BadInputException {
        // 구현 1.
        if(!operationInput.matches(OPERATION_REG)) {
            throw new BadInputException("연산기호");
        }

        switch(operationInput) {
            case "+" -> calculator.setOperation(new AddOperation());

            case "-" -> calculator.setOperation(new SubstractOperation());

            case "*" -> calculator.setOperation(new MultiplyOperation());

            case "/" -> calculator.setOperation(new DivideOperation());

            case "^" -> {calculator.setMonomialOperation(new ExponentationOperation()); monomial = true;}

            case "√" -> {calculator.setMonomialOperation(new SquareRootOperation()); monomial = true;}
        }
    }

    public double executeCalculator() {
        return calculator.calculate(monomial);
    }
}