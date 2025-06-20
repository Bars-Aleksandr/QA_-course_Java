package calculator.logging.factory;

import calculator.Calculable;
import calculator.Calculator;
import calculator.ICalculableFactory;
import calculator.logging.ILoggableOnConsole;
import calculator.logging.LogCalculate;

public class LogCalculableFactory implements ICalculableFactory {

    private ILoggableOnConsole logger;

    public LogCalculableFactory(ILoggableOnConsole logger) {
        this.logger = logger;
    }

    @Override
    public Calculable create(int primaryArg) {
        return new LogCalculate(new Calculator(primaryArg), logger);
    }
}
