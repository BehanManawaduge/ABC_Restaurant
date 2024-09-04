
package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenNavigator {
    private static Stage stage;

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void switchScreen(String fxml) throws IOException {
        Parent root = FXMLLoader.load(ScreenNavigator.class.getResource("/views/" + fxml));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
