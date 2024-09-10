package presentationLayer.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logicLayer.HRS;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignInA {

    @FXML
    private Button btn_Login;

    @FXML
    private Label label_invalid;

    @FXML
    private TextField txt_user;

    @FXML
    private PasswordField txt_password;


    @FXML
    private Button btn_close;

    @FXML
    void closeClick(ActionEvent event) {
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();

    }

    @FXML
    void LogInClick(ActionEvent event) {
        HRS hrs = new HRS();
        hrs.registerReceptionist("s","s","1","as","2131","21312","12313");
        String email = txt_user.getText();
        String password = txt_password.getText();

        System.out.println(email);
        System.out.println(password);
        if (hrs.LoginAdmin(email, password)) {
            ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("AdminPage.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900, 600);
                Stage stage = new Stage();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
        }
        else {
            label_invalid.setVisible(true);
        }


    }

}
