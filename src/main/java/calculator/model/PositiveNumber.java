package calculator.model;

public class PositiveNumber {

    public static final String NON_POSITIVE_NUMBER = "양수를 입력해야 합니다.";
    public static final long MIN_RANGE = 1L;
    public static final String INVALID_VALUE_EXCEPTION_MESSAGE = "피연산자는 양수만 입력할 수 있습니다.";
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
        try {
            return Long.parseLong(positiveNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INVALID_VALUE_EXCEPTION_MESSAGE);
        }
    }

    private void validateRange(long number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(NON_POSITIVE_NUMBER);
        }
    }

    private boolean isOutOfRange(long number) {
        return number < MIN_RANGE;
    }
}
