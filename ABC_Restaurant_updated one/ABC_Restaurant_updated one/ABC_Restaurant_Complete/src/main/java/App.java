
package main;

import javafx.application.Application;
import javafx.stage.Stage;
import util.ScreenNavigator;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreenNavigator.setStage(primaryStage);
        ScreenNavigator.switchScreen("login.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
