package core;

public class ComplexNumberService implements IComplexNumberService{

    @Override
    public ComplexNumber createComplexNumber(double a, double b) {
        return new ComplexNumber(a, b);
    }

}
