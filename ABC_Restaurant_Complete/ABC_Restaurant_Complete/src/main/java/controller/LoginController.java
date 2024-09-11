// src/main/java/controller/LoginController.java
package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;  // Ensure this matches the fx:id in the FXML

    private UserService userService = new UserService();

    @FXML
    private void initialize() {
        // Initialize any necessary elements or event handlers
    }

    @FXML
    private void login() throws SQLException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Please enter both username and password.");
            return;
        }

        try {
            User user = userService.authenticateUser(username, password);
            if (user != null) {
                // Redirect to appropriate dashboard based on role
                switch (user.getRole()) {
                    case "Admin":
                        loadDashboard("/views/admin_dashboard.fxml", "Admin Dashboard");
                        break;
                    case "Staff":
                        loadDashboard("/views/staff_dashboard.fxml", "Staff Dashboard");
                        break;
                    case "Customer":
                        loadDashboard("/views/customer_dashboard.fxml", "Customer Dashboard");
                        break;
                    default:
                        showAlert("Error", "Unknown user role!");
                        break;
                }
            } else {
                showAlert("Login Failed", "Invalid username or password.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load the dashboard.");
        }
    }

    private void loadDashboard(String fxmlPath, String title) throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();  // Ensure loginButton is not null
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
        stage.setTitle(title);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
