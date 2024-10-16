package lv2_UseClassCalculator;

public class Main {
    public static void main(String[] args) {

        CalculatorApp app = new CalculatorApp();

        while (!app.getExit()) {
            try {
                app.start();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}