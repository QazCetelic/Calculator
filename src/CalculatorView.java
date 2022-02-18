import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class CalculatorView extends BorderPane {
    private NumberInput input;

    private GridPane grid;
    private CalculatorModel model;

    public CalculatorView() {
        input = new NumberInput();
        input.setPrefSize(300, 50);

        // Ensures the user can always type numbers by preventing the user from losing focus after pressing a button
        input.focusedProperty().addListener((observable, focusedBefore, focusedNow) -> {
            if (!focusedNow) input.requestFocus();
        });

        setTop(input);

        model = new CalculatorModel(input);

        grid = new GridPane();

        addButton('1', 0, 0, event -> input.append('1'));
        addButton('2', 1, 0, event -> input.append('2'));
        addButton('3', 2, 0, event -> input.append('3'));
        addButton('4', 0, 1, event -> input.append('4'));
        addButton('5', 1, 1, event -> input.append('5'));
        addButton('6', 2, 1, event -> input.append('6'));
        addButton('7', 0, 2, event -> input.append('7'));
        addButton('8', 1, 2, event -> input.append('8'));
        addButton('9', 2, 2, event -> input.append('9'));

        addButton('+', 3, 0, event -> model.applyOperation(Double::sum, '+'));
        addButton('-', 3, 1, event -> model.applyOperation(Double::min, '-'));
        addButton('×', 3, 2, event -> model.applyOperation((a, b) -> a * b, '×'));
        addButton('÷', 3, 3, event -> model.applyOperation((a, b) -> a / b, '÷'));

        addButton('.', 0, 3, event -> input.append('.'));
        addButton('0', 1, 3, event -> input.append('0'));
        addButton('=', 2, 3, event -> {
            model.calculate();
        });

        setCenter(grid);
    }

    private void addButton(char c, int column, int row, EventHandler<ActionEvent> action) {
        Button button = new Button(String.valueOf(c));

        widthProperty().addListener((observable, oldValue, newValue) -> {
            scale(button, getHeight(), (double) newValue);
        });
        heightProperty().addListener((observable, oldValue, newValue) -> {
            scale(button, (double) newValue, getWidth());
        });

        grid.add(button, column, row);
        button.onActionProperty().set(action);
    }

    /**
     * @param node the button to scale
     */
    private void scale(Labeled node, double height, double width) {
        double buttonWidth = width / 4;
        double buttonHeight = height / 4;
        double fontSize = Math.min(height / 12, width / 12);

        Font font = fontSize > 1 ? Font.font(fontSize) : Font.font(1);
        node.setFont(font);

        node.setPrefHeight(buttonHeight);
        node.setPrefWidth(buttonWidth);
    }
}
