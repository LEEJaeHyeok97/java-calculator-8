package calculator.controller;

import calculator.exception.ErrorMessage;
import calculator.model.Calculator;
import calculator.model.vo.PositiveNumber;
import calculator.util.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Arrays;
import java.util.List;

public class CalculatorController {

    private static final String WHITESPACE = " ";
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
            throw new IllegalArgumentException(ErrorMessage.WHITE_SPACE_CONTAINS.getErrorMessage());
        }
    }

    private void validateBlank(String input) {
        if (!input.isEmpty() && input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_WHITESPACE.getErrorMessage());
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
