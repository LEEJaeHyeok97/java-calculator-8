package calculator.model;

import calculator.model.vo.PositiveNumber;
import java.math.BigInteger;
import java.util.List;

public class Calculator {

    public static final String SUM_OVERFLOW_EXCEPTION_MESSAGE = "계산 결과가 최대 범위를 초과했습니다.";
    private final List<PositiveNumber> positiveNumbers;

    public Calculator(List<PositiveNumber> positiveNumber) {
        this.positiveNumbers = positiveNumber;
    }

    public static Calculator of(List<PositiveNumber> positiveNumbers) {
        return new Calculator(positiveNumbers);
    }

    public long calculateSum() {
        BigInteger calculatedSum = getCalculatedSum();
        validateOverflow(calculatedSum);

        return toLong(calculatedSum);
    }

    private BigInteger getCalculatedSum() {
        return positiveNumbers.stream()
                .map(positiveNumber -> BigInteger.valueOf(positiveNumber.getNumber()))
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    private void validateOverflow(BigInteger calculatedValue) {
        if (calculatedValue.compareTo(PositiveNumber.MAX_VALUE_BIG_INTEGER) > 0) {
            throw new IllegalArgumentException(SUM_OVERFLOW_EXCEPTION_MESSAGE);
        }
    }

    private long toLong(BigInteger calculatedValue) {
        return calculatedValue.longValue();
    }
}
