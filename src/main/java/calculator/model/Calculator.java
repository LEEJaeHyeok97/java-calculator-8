package calculator.model;

import java.util.List;

public class Calculator {

    public static final long DEFAULT_VALUE = 0L;
    private final List<PositiveNumber> positiveNumbers;

    public Calculator(List<PositiveNumber> positiveNumber) {
        this.positiveNumbers = positiveNumber;
    }

    public static Calculator of(List<PositiveNumber> positiveNumbers) {
        return new Calculator(positiveNumbers);
    }

    public long sumCalculate() {
        return positiveNumbers.stream()
                .map(PositiveNumber::getNumber)
                .reduce(DEFAULT_VALUE, Long::sum);
    }
}
