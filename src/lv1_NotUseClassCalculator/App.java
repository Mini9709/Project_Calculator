package lv1_NotUseClassCalculator;
import java.util.Scanner;

public class App {
    // 클래스가 없는 사칙연산
    // 예외처리 없이 간단한 사칙연산 계산기

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        // exit이 입력될 때 까지 루프
        while (!exit){


            System.out.println("첫 번째 숫자를 입력하세요 : ");
            double firstNumber = sc.nextDouble();
            System.out.println("두 번째 숫자를 입력하세요 : ");
            double secondNumber = sc.nextDouble();

            System.out.println("사칙연산 기호를 입력하세요 : ");
            char operator = sc.next().charAt(0);

            // 0으로 나눌 시 오류 메시지 출력
            if (secondNumber == 0 && operator == '/'){
                System.out.println("0으로 나눌 수 없습니다.");
            }
            else {
                switch (operator) {
                    case '+' -> System.out.println("결과 : " + (firstNumber - secondNumber));
                    case '-' -> System.out.println("결과 : " + (firstNumber - secondNumber));
                    case '*' -> System.out.println("결과 : " + (firstNumber * secondNumber));
                    case '/' -> System.out.println("결과 : " + (firstNumber / secondNumber));
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String finish = sc.next();

            //연산이 한 번 진행된 후 종료 여부 확인
            if (finish.equals("exit")){
                exit = true;
            }
        }
    }
}

