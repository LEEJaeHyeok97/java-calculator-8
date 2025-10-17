package calculator.model;

public class PositiveNumber {

    public static final String NON_POSITIVE_NUMBER = "양수를 입력해야 합니다.";
    public static final long MIN_RANGE = 1L;
    public static final String INVALID_DELIMITER_EXCEPTION_MESSAGE = "구분자가 잘못 입력 되었습니다. 커스텀 구분자, 기본 구분자를 확인하세요";
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
            throw new IllegalArgumentException(INVALID_DELIMITER_EXCEPTION_MESSAGE);
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
