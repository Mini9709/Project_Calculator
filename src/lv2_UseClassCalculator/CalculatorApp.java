package lv2_UseClassCalculator;

import lv2_UseClassCalculator.exceptionClass.BadInputException;
import lv2_UseClassCalculator.operationClass.*;
import lv3_ChallengeFunction.OperatorType;

import java.util.Scanner;

public class CalculatorApp {

    private boolean exit = false;  //종료 여부 boolean 값
    private static boolean monomial; // 단항식인지 확인하는 boolean값

    private final Calculator calculator = new Calculator();

    public boolean getExit(){
        return exit;
    }

    public boolean getMonomial() {
        return monomial;
    }

    public void start() throws Exception{
        monomial = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("계산기 실행\n사용 가능한 연산기호 :\n" +
                "+ : 더하기    - : 빼기   * : 곱하기\n" +
                "/ : 나누기    ^ : 제곱   √ : 제곱근\n");
        System.out.println("첫번째 숫자를 입력해주세요!");

        try {
            double firstInput = scanner.nextDouble();
            calculator.setFirstNumber(firstInput);
        } catch (Exception e) {
            throw new BadInputException("숫자");
        }

        System.out.println("연산자를 입력해주세요!");
        scanner.nextLine();
        String operator = scanner.nextLine();

        // enum(연산 기호)에 존재하지 않은 문자열이 들어갔을 경우 예외처리
        if(!OperatorType.ADDITION.containsOfLabel(operator)) {
            throw new BadInputException("연산기호");
        }
        switch(operator) {
            case "+" -> calculator.setOperation(new AddOperation());
            case "-" -> calculator.setOperation(new SubstractOperation());
            case "*" -> calculator.setOperation(new MultiplyOperation());
            case "/" -> calculator.setOperation(new DivideOperation());
            case "^" -> {calculator.setMonomialOperation(new SquareOperation()); monomial = true;}
            case "√" -> {calculator.setMonomialOperation(new SquareRootOperation()); monomial = true;}
        }

        if (!getMonomial()){
            System.out.println("두번째 숫자를 입력해주세요!");
            try {
                double secondInput = scanner.nextDouble();
                scanner.nextLine();
                calculator.setSecondNumber(secondInput);
            } catch (Exception e) {
                throw new BadInputException("숫자");  // 입력값 타입 변환
            }
        }

        System.out.println("연산 결과 : " + calculator.calculate(monomial));

        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제)");
        System.out.println("저장된 데이터를 출력하시겠습니까? (load 입력 시 종료)");
        String nextInput = scanner.nextLine();

        switch (nextInput){ // 종료, 제거, 출력 기능 구현
            case "exit" -> {exit= true; System.out.println("계산을 종료합니다.");}
            case "remove" -> {calculator.removeNumber(); System.out.println("먼저 저장된 데이터를 삭제하였습니다.");}
            case "load" -> {System.out.println(calculator.getDoubleQueue().toString());}
            default -> System.out.println("다시 계산합니다.");
        }
    }
}
