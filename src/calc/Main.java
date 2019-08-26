package calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *  JavaFX calculator by Ryan Vagle
 *
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("calc.fxml"));
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(new Scene(root, 300, 400));
        primaryStage.show();
        root.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
