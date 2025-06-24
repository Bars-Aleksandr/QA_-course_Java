package logging;

import core.ComplexNumber;

public interface Calculable {
    Calculable sum(ComplexNumber other);
    Calculable multi(ComplexNumber other);
    Calculable div(ComplexNumber other);
    ComplexNumber getResult();
}
