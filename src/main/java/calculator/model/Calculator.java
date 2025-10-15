package calculator.model;

import java.util.List;

public class Calculator {

    private final Operator operator;
    private final List<PositiveNumber> positiveNumber;

    public Calculator(Operator operator, List<PositiveNumber> positiveNumber) {
        this.operator = operator;
        this.positiveNumber = positiveNumber;
    }
}
