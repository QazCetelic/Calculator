import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class NumberInput extends TextField {

    public NumberInput() {
        textProperty().addListener((observable, oldValue, newValue) -> {
            if (validate(newValue)) {
                // Valid number
                setBorder(null);
            }
            else {
                // Invalid number
                setText(oldValue.replace("[^\\d]", ""));
                BorderStroke stroke = new BorderStroke(
                    Color.RED,
                    BorderStrokeStyle.SOLID,
                    new CornerRadii(2),
                    BorderWidths.DEFAULT
                );
                setBorder(new Border(stroke));
            }
        });
    }

    /**
     * @return The number in the text field, or 0 if the text field is empty.
     */
    public double getNumber() {
        if (getText().isEmpty()) {
            return 0;
        }
        else {
            return Double.parseDouble(getText());
        }
    }

    /**
     * @param number The number to set the text field to.
     */
    public void setNumber(double number) {
        // Removes .0
        setText(String.valueOf(number).replaceAll("\\.0$", ""));
    }

    /**
     * Appends character to the text field if that would be valid.
     * @param c
     */
    public void append(char c) {
        String appended = getText() + c;
        if (validate(appended)) {
            setText(appended);
        }
    }

    private boolean validate(String s) {
        return s.matches("\\d*") || s.matches("\\d*\\.\\d*");
    }
}
