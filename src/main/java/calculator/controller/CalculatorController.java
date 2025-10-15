package calculator.controller;

import calculator.model.Calculator;
import calculator.model.PositiveNumber;
import calculator.util.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Arrays;
import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Calculator calculator = createCalculator(getSeparatedNumbers());
        getResult(calculator);
    }

    private String[] getSeparatedNumbers() {
        return Separator.separate(getInputString());
    }

    private String getInputString() {
        return inputView.inputString();
    }

    private Calculator createCalculator(String[] numbers) {
        return Calculator.of(getPositiveNumbers(numbers));
    }

    private List<PositiveNumber> getPositiveNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .map(PositiveNumber::from)
                .toList();
    }

    private void getResult(Calculator calculator) {
        outputView.printResult(calculator.calculate());
    }
}
