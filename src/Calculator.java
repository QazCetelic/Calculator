import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        CalculatorView calcView = new CalculatorView();

        // Calculate calculator view size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double min = Math.min(screenSize.getWidth(), screenSize.getHeight());
        double scaled = min / 12;

        Scene scene = new Scene(calcView, scaled * 3, scaled * 4);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
