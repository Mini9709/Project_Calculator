package lv2_UseClassCalculator;

import lv2_UseClassCalculator.operationClass.AbstractMonomialOperation;
import lv2_UseClassCalculator.operationClass.AbstractOperation;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private int firstNumber;
    private int secondNumber;

    private static Queue<Double> doubleQueue = new LinkedList<>();
    private AbstractOperation operation;
    private AbstractMonomialOperation monomialOperation;

    public void setOperation(AbstractOperation operation) {
        this.operation = operation;
    }

    public void setMonomialOperation(AbstractMonomialOperation monomialOperation) { this.monomialOperation = monomialOperation; }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
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