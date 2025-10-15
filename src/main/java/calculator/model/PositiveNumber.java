package calculator.model;

public class PositiveNumber {

    public static final String NON_POSITIVE_NUMBER = "양수를 입력해야 합니다.";
    public static final long MIN_RANGE = 1L;
    private final long number;

    public PositiveNumber(long number) {
        validateRange(number);
        this.number = number;
    }

    public long getNumber() {
        return number;
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
