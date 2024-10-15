package useClassCalculator;

import java.util.Scanner;

public class CalculatorApp {

    public static boolean start() throws Exception{
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);


        System.out.println("계산기 실행\n사용 가능한 연산기호 :\n" +
                "+ : 더하기    - : 빼기   * : 곱하기\n" +
                "/ : 나누기    ^ : 제곱   √ : 제곱근\n");

        System.out.println("첫번째 숫자를 입력해주세요!");
        String firstInput = scanner.nextLine();
        parser.parseFirstNum(firstInput);     // 입력값 타입 변환

        System.out.println("연산자를 입력해주세요!");
        String operator = scanner.nextLine();
        parser.parseOperator(operator);     // 입력값 타입 변환

        if (!parser.getMonomial()){
            System.out.println("두번째 숫자를 입력해주세요!");
            String secondInput = scanner.nextLine();
            parser.parseSecondNum(secondInput);     // 입력값 타입 변환
        }

        System.out.println("연산 결과 : " + parser.executeCalculator());
        return true;
    }


}
