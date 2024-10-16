package lv2_UseClassCalculator;

import lv2_UseClassCalculator.exceptionClass.BadInputException;
import lv2_UseClassCalculator.operationClass.*;
import lv3_ChallengeFunction.NumberType;
import lv3_ChallengeFunction.OperatorType;

import java.util.Queue;

public class Parser {
//    lv2 진행중에 사용한 상수값들
//    private static final String OPERATION_REG = "[+\\-*/√^]";
//    private static final String NUMBER_REG = "^[0-9]*$";

    private static boolean monomial = false; // 단항식인지 확인하는 boolean값

    private final Calculator calculator = new Calculator();


    public boolean getMonomial() {
        return monomial;
    }

    // 각각의 입력값을 알맞는 타입으로 전환
    public void parseFirstNum(String firstInput) throws BadInputException {

        // enum 타입 메서드 추가
        if(!NumberType.ONE.containsOfLabel(firstInput)) {
            throw new BadInputException("숫자");
        }

        calculator.setFirstNumber(Integer.parseInt(firstInput));
    }

    public void parseSecondNum(String secondInput) throws BadInputException {

        if(!NumberType.ONE.containsOfLabel(secondInput)) {
            throw new BadInputException("숫자");
        }

        calculator.setSecondNumber(Integer.parseInt(secondInput));
    }

    public void parseOperator(String operationInput) throws BadInputException {

        // enum 타입 메서드 추가
        if(!OperatorType.ADDITION.containsOfLabel(operationInput)) {
            throw new BadInputException("연산기호");
        }

        switch(operationInput) {
            case "+" -> calculator.setOperation(new AddOperation());

            case "-" -> calculator.setOperation(new SubstractOperation());

            case "*" -> calculator.setOperation(new MultiplyOperation());

            case "/" -> calculator.setOperation(new DivideOperation());

            case "^" -> {calculator.setMonomialOperation(new SquareOperation()); monomial = true;}

            case "√" -> {calculator.setMonomialOperation(new SquareRootOperation()); monomial = true;}
        }
    }


    public double executeCalculator() {
        return calculator.calculate(monomial);
    }

    public void removeNumber(){
        calculator.removeNumber();
    }

    public Queue<Double> getDoubleQueue() { return calculator.getDoubleQueue();}
}