import java.util.Observable;
import java.util.function.BiFunction;

public class CalculatorModel {
    private double oldValue;

    private BiFunction<Double, Double, Double> operation;
    private char operationChar;

    private final NumberInput input;
    public CalculatorModel(NumberInput input) {
        this.input = input;
        oldValue = 0d;
    }

    /**
     * Sets the operation to be performed and the first value that is used in the operation.
     * The second value is entered by the user after.
     * @param operation
     */
    public void applyOperation(BiFunction<Double, Double, Double> operation, char operationChar) {
        oldValue = input.getNumber();
        this.operation = operation;
        this.operationChar = operationChar;
        input.clear();
    }

    public double calculate() {
        double result = operation.apply(oldValue, input.getNumber());
        String a = String.valueOf(oldValue).replaceAll("\\.0$", "");
        String b = String.valueOf(input.getNumber()).replaceAll("\\.0$", "");
        String c = String.valueOf(result).replaceAll("\\.0$", "");
        System.out.printf("%s %s %s = %s%n", a, operationChar, b, c);
        input.setNumber(result);
        return result;
    }
}
