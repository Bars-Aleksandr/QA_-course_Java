package adapter;

import core.ComplexNumber;
import logging.Calculable;

public class ComplexNumberAdapter implements Calculable {
   
    private ComplexNumber result;

    public ComplexNumberAdapter(ComplexNumber complex) {
        this.result = complex;
    }

    @Override
    public Calculable sum(ComplexNumber other) {
        double newReal = result.getRealNumber() + other.getRealNumber();
        double newImag = result.getImagNumber() + other.getImagNumber();
        result = new ComplexNumber(newReal, newImag);
        return this;
    }

    @Override
    public Calculable multi(ComplexNumber other) {
        double realPart = result.getRealNumber() * other.getRealNumber() - result.getImagNumber() * other.getImagNumber();
        double imagPart = result.getRealNumber() * other.getImagNumber() + result.getImagNumber() * other.getRealNumber();
        result = new ComplexNumber(realPart, imagPart);
        return this;
    }

    @Override
    public Calculable div(ComplexNumber other) {
        double denom = other.getRealNumber()*other.getRealNumber() + other.getImagNumber()*other.getImagNumber();
        if (denom == 0) throw new ArithmeticException("Деление на ноль");
        double realPart = (result.getRealNumber()*other.getRealNumber() + result.getImagNumber()*other.getImagNumber()) / denom;
        double imagPart = (result.getImagNumber()*other.getRealNumber() - result.getRealNumber()*other.getImagNumber()) / denom;
        result = new ComplexNumber(realPart, imagPart);
        return this;
    }

    @Override
    public ComplexNumber getResult() {
        return result;
    }
}
