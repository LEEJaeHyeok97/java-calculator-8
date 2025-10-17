package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String WHITESPACE = " ";
    public static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String inputString() {
        System.out.println(INPUT_PROMPT_MESSAGE);
        String input = Console.readLine();

        validateBlank(input);
        validateWhitespace(input);
        return input;
    }

    private void validateWhitespace(String input) {
        if (input.contains(WHITESPACE)) {
            throw new IllegalArgumentException("문자열에 공백문자를 입력할 수 없습니다.");
        }
    }

    private void validateBlank(String input) {
        if (!input.isEmpty() && input.isBlank()) {
            throw new IllegalArgumentException("공백 문자만 입력할 수 없습니다.");
        }
    }
}
