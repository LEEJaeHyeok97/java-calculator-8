package calculator.model;

import java.util.List;

public class Calculator {

    public static final long DEFAULT_VALUE = 0L;
    private final List<PositiveNumber> positiveNumber;

    public Calculator(List<PositiveNumber> positiveNumber) {
        this.positiveNumber = positiveNumber;
    }

    public long calculate() {
        return positiveNumber.stream()
                .map(PositiveNumber::getNumber)
                .reduce(DEFAULT_VALUE, Long::sum);
    }
}
