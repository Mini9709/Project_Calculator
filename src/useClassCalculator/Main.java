package useClassCalculator;

public class Main {
    public static void main(String[] args) {
        boolean calculateEnded = false;
        // 구현 2.
        CalculatorApp app = new CalculatorApp();

        while (!calculateEnded) {
            try {
                calculateEnded = app.start();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}