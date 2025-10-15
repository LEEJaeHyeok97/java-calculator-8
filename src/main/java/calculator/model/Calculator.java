package calculator.model;

import java.util.List;

public class Calculator {

    private final List<PositiveNumber> positiveNumber;

    public Calculator(List<PositiveNumber> positiveNumber) {
        this.positiveNumber = positiveNumber;
    }

    public long calculate() {
        return positiveNumber.stream()
                .map(PositiveNumber::getNumber)
                .reduce(0L, Long::sum);
    }
}
