package lv2_UseClassCalculator;

import lv2_UseClassCalculator.operationClass.AbstractMonomialOperation;
import lv2_UseClassCalculator.operationClass.AbstractOperation;

import java.util.LinkedList;
import java.util.Queue;

// 제네릭 사용 : Number 하위 클래스인 변수들은 전부 사용 가능
public class Calculator<T extends Number> {
    private T firstNumber;
    private T secondNumber;

    private static Queue<Double> doubleQueue = new LinkedList<>();
    private AbstractOperation operation;
    private AbstractMonomialOperation monomialOperation;

    public void setOperation(AbstractOperation operation) {
        this.operation = operation;
    }

    public void setMonomialOperation(AbstractMonomialOperation monomialOperation) { this.monomialOperation = monomialOperation; }

    public void setFirstNumber(T firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(T secondNumber) {
        this.secondNumber = secondNumber;
    }

    public Queue<Double> getDoubleQueue() { return doubleQueue; }

    public double calculate(boolean monomial) { // 단항식 여부에 따라 다른 메서드 실행
        double answer = 0;
        if (monomial){
            answer = monomialOperation.operate(this.firstNumber);
        }
        else{
            try { // 0으로 나눌 경우 에러 출력
                answer = operation.operate(this.firstNumber, this.secondNumber);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        doubleQueue.add(answer);
        return answer;
    }

    public void removeNumber(){
        this.doubleQueue.poll();
    }
}