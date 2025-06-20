package calculator.logging;

import calculator.Calculable;

public class LogCalculate implements Calculable {
    private Calculable decorated;
    private ILoggableOnConsole logger;

    public LogCalculate(Calculable decorated, ILoggableOnConsole logger) {
        this.decorated = decorated;
        this.logger = logger;
    }

    @Override
    public Calculable sum(int arg) {
        int firstArg = decorated.getResult();
        logger.log("Первый аргумент" + firstArg + "начало вызоыва метода sum(int arg)" + arg);
        Calculable result = decorated.sum(arg);
        logger.log("Вызов метода sum произошел успешно");
        return result;
    }

    @Override
    public Calculable multi(int arg) {
        int firstArg = decorated.getResult();
        logger.log("Первый аргумент" + firstArg + "начало вызоыва метода multi(int arg)" + arg);
        Calculable result = decorated.multi(arg);
        logger.log("Вызов метода multi произошел успешно");
        return result;
    }

    @Override
    public int getResult() {
        int result = decorated.getResult();
        logger.log("Полученый результат: " + result);
        return result;
    }
}
