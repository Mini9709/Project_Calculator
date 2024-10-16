package lv2_UseClassCalculator.exceptionClass;

public class BadOperationException extends Exception{
    public BadOperationException(){
        super("0으로 나눌 수 없습니다!!\n");
    }
}
