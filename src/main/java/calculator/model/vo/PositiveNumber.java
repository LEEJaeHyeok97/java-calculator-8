package calculator.model.vo;

import calculator.exception.ErrorMessage;
import java.math.BigInteger;

public class PositiveNumber {

    public static final long MIN_RANGE = 1L;
    public static final long MAX_VALUE = Long.MAX_VALUE;
    public static final BigInteger MAX_VALUE_BIG_INTEGER = BigInteger.valueOf(MAX_VALUE);
    private final long number;

    public PositiveNumber(long number) {
        validateRange(number);
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public static PositiveNumber from(String positiveNumber) {
        return new PositiveNumber(getParsedLong(positiveNumber));
    }

    private static long getParsedLong(String positiveNumber) {
        return toLong(positiveNumber);
    }

    private static long toLong(String positiveNumber) {
        return parseLong(positiveNumber);
    }

    private static long parseLong(String positiveNumber) {
        validateOverflow(positiveNumber);
        try {
            return Long.parseLong(positiveNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getErrorMessage());
        }
    }

    private static void validateOverflow(String positiveNumber) {
        try {
            if (new BigInteger(positiveNumber).compareTo(MAX_VALUE_BIG_INTEGER) > 0) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_OVERFLOW.getErrorMessage());
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getErrorMessage());
        }
    }

    private void validateRange(long number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_NUMBER.getErrorMessage());
        }
    }

    private boolean isOutOfRange(long number) {
        return number < MIN_RANGE;
    }
}
