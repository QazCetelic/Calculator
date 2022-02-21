import com.sun.istack.internal.NotNull;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Calculator extends Application {

    @Override
    public void start(@NotNull Stage primaryStage) {
        CalculatorView calcView = new CalculatorView();

        // Calculate calculator view size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double min = Math.min(screenSize.getWidth(), screenSize.getHeight());
        double scaled = min / 12;

        Scene scene = new Scene(calcView, scaled * 3, scaled * 4);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
