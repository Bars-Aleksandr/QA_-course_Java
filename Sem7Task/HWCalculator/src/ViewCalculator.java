import java.util.Scanner;

import core.ComplexNumber;
import factory.CalculatorFactory;
import logging.Calculable;

public class ViewCalculator {
    private Scanner in = new Scanner(System.in);
    private CalculatorFactory calculatorFactory;

    public ViewCalculator(CalculatorFactory calculatorFactory) {
        this.calculatorFactory = calculatorFactory;
    }

    public void run() {
        while (true) {
            ComplexNumber complexNumberFirst = getComplexNumberFromConsole("часть первого числа");

            Calculable calc = calculatorFactory.createCalculator(complexNumberFirst, "log.txt");
            while (true) {
                String cmd = promptString("Введите команду (*, +, /) : ");
                if (cmd.equals("*")) {
                    ComplexNumber complexNumberSecond = getComplexNumberFromConsole("часть второго числа");
                    calc.multi(complexNumberSecond);
                    System.out.println("Итоговый результат: " + calc.getResult());
                    break;
                }
                if (cmd.equals("+")) {
                    ComplexNumber complexNumberSecond = getComplexNumberFromConsole("часть второго числа");
                    calc.sum(complexNumberSecond);
                    System.out.println("Итоговый результат: " + calc.getResult());
                    break;
                }
                if (cmd.equals("/")) {
                    ComplexNumber complexNumberSecond = getComplexNumberFromConsole("часть второго числа");
                    calc.div(complexNumberSecond);
                    System.out.println("Итоговый результат: " + calc.getResult());
                    break;
                }
                
            }
            String cmd = promptString("Еще посчитать (Y/N)?");
            if (cmd.equalsIgnoreCase("Y")) {
                continue;
            }
            break;
        }

    }

    private String promptString(String message) {
     
        System.out.print(message);
        return in.nextLine();

    }

    private ComplexNumber getComplexNumberFromConsole(String positionArgMessage) {
        double realNumber = promptNumber("Введите действительную " + positionArgMessage + ": ");
        double imagNumber = promptNumber("Введите мнимую " + positionArgMessage + ": ");
        return new ComplexNumber(realNumber, imagNumber);
    }

    private int promptNumber(String message) {

        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }

}
