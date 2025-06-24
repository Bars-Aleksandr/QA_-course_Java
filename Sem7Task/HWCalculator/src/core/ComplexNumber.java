package core;

public class ComplexNumber {
    private final double realNumber;
    private final double imagNumber;

    public ComplexNumber(double realNumber, double imagNumber) {
        this.realNumber = realNumber;
        this.imagNumber = imagNumber;
    }

    public double getRealNumber() {
        return realNumber;
    }

    public double getImagNumber() {
        return imagNumber;
    }

    @Override
    public String toString() {
        return realNumber + " + " + imagNumber + "i";
    }
}
