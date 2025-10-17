package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String inputString() {
        System.out.println(INPUT_PROMPT_MESSAGE);

        return Console.readLine();
    }
}
