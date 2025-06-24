package factory;

import adapter.ComplexNumberAdapter;
import core.ComplexNumber;
import logging.Calculable;
import logging.ConsoleLogger;
import logging.FileLogger;
import logging.LogCalculate;

public class CalculatorFactory {

    public Calculable createCalculator(ComplexNumber initialValue, boolean withLogging) {
        Calculable calc = new ComplexNumberAdapter(initialValue);
        
        if (withLogging) {
            calc = new LogCalculate(calc, new ConsoleLogger());
        }
        
        return calc;
    }

    public Calculable createCalculator(ComplexNumber initialValue, String fileName){
        Calculable calc = new ComplexNumberAdapter(initialValue);
        if (fileName != null) {
            calc = new LogCalculate(calc, new FileLogger(fileName));
        }

        return calc;
    }
}
