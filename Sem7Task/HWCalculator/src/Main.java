
import factory.CalculatorFactory;

public class Main {

    public static void main(String[] args) {

        CalculatorFactory calculatorFactory = new CalculatorFactory();
        ViewCalculator view = new ViewCalculator(calculatorFactory);
        view.run();

    }
}
