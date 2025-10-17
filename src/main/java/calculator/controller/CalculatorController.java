package calculator.controller;

import calculator.model.Calculator;
import calculator.model.PositiveNumber;
import calculator.util.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Arrays;
import java.util.List;

public class CalculatorController {

    private static final String WHITESPACE = " ";
    public static final String WHITE_SPACE_CONTAINS_EXCEPTION_MESSAGE = "문자열에 공백문자를 입력할 수 없습니다.";
    public static final String ONLY_WHITESPACE_EXCEPTION_MESSAGE = "공백 문자만 입력할 수 없습니다.";

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Calculator calculator = createCalculator(getSeparatedNumbers());
        printResult(calculator);
    }

    private String[] getSeparatedNumbers() {
        return Separator.separate(getInputString());
    }

    private String getInputString() {
        String inputString = inputView.inputString();
        validateInputString(inputString);

        return inputString;
    }

    private void validateInputString(String inputString) {
        validateBlank(inputString);
        validateWhitespace(inputString);
    }

    private void validateWhitespace(String input) {
        if (input.contains(WHITESPACE)) {
            throw new IllegalArgumentException(WHITE_SPACE_CONTAINS_EXCEPTION_MESSAGE);
        }
    }

    private void validateBlank(String input) {
        if (!input.isEmpty() && input.isBlank()) {
            throw new IllegalArgumentException(ONLY_WHITESPACE_EXCEPTION_MESSAGE);
        }
    }

    private Calculator createCalculator(String[] numbers) {
        return Calculator.of(getPositiveNumbers(numbers));
    }

    private List<PositiveNumber> getPositiveNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .filter(number -> !number.isEmpty())
                .map(PositiveNumber::from)
                .toList();
    }

    private void printResult(Calculator calculator) {
        outputView.printResult(calculator.calculateSum());
    }
}
