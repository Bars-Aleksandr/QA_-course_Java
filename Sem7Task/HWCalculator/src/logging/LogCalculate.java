package logging;

import core.ComplexNumber;

public class LogCalculate implements Calculable {
    private Calculable decorated;
    private ILogger logger;

    public LogCalculate(Calculable decorated, ILogger logger) {
        this.decorated = decorated;
        this.logger = logger;
    }

    @Override
    public Calculable sum(ComplexNumber other) {

        logger.log(
                "First argument: " + decorated.getResult() + " - start of method call sum(ComplexNumber other): " + other);

        Calculable res = decorated.sum(other);

        logger.log("Result: " + res.getResult());
        return res;
    }

    @Override
    public Calculable multi(ComplexNumber other) {
        logger.log(
                "First argument: " + decorated.getResult() + " - start of method call multi(ComplexNumber other): " + other);

        Calculable res = decorated.multi(other);

        logger.log("Result: " + res.getResult());
        return res;
    }

    @Override
    public Calculable div(ComplexNumber other) {
        logger.log(
                "First argument: " + decorated.getResult() + " - start of method call div(ComplexNumber other): " + other);

        try {
            Calculable res = decorated.div(other);
            logger.log("Result: " + res.getResult());
            return res;
        } catch (ArithmeticException e) {
            logger.log("Ошибка деления: " + e.getMessage());
            throw e;
        }

    }

    @Override
    public ComplexNumber getResult() {
        ComplexNumber res = decorated.getResult();
        logger.log("Result received: " + res);
        return res;
    }
}
