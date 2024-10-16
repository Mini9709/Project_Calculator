package lv2_UseClassCalculator;

import java.util.Scanner;

public class CalculatorApp {

    private boolean exit = false;  //종료 여부 boolean 값

    public boolean getExit(){
        return exit;
    }

    public void start() throws Exception{
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

        System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
        System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제)");
        System.out.println("저장된 데이터를 출력하시겠습니까? (load 입력 시 종료)");
        String nextInput = scanner.nextLine();

        switch (nextInput){ // 종료, 제거, 출력 기능 구현
            case "exit" -> {exit= true; System.out.println("계산을 종료합니다.");}
            case "remove" -> {parser.removeNumber(); System.out.println("먼저 저장된 데이터를 삭제하였습니다.");}
            case "load" -> {System.out.println(parser.getDoubleQueue().toString());}
            default -> System.out.println("다시 계산합니다.");
        }
    }
}
