package calculator.exception;

public enum ErrorMessage {

    SUM_OVERFLOW("계산 결과가 최대 범위를 초과했습니다."),
    NUMBER_OVERFLOW("입력 가능한 값의 범위를 초과했습니다."),
    INVALID_VALUE("피연산자는 양수만 입력할 수 있습니다."),
    NON_POSITIVE_NUMBER("양수를 입력해야 합니다."),
    ONLY_WHITESPACE("공백 문자만 입력할 수 없습니다."),
    WHITE_SPACE_CONTAINS("문자열에 공백문자를 입력할 수 없습니다."),
    NUMBER_DELIMITER("숫자는 구분자가 될 수 없습니다."),
    MISSING_CUSTOM_DELIMITER("커스텀 구분자가 입력되지 않았습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return this.message;
    }
}
