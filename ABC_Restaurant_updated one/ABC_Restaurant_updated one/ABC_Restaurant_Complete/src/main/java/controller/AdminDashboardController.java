package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardController {

    @FXML
    private Button manageUsersButton;

    @FXML
    private Button viewReportsButton;

    @FXML
    private Button manageReservationsButton;

    @FXML
    private Button logoutButton;

    @FXML
    public void initialize() {
    }

    @FXML
    public void handleManageUsers() {
        loadScreen("/views/manage_users.fxml", "Manage Users");
    }

    @FXML
    public void handleViewReports() {
        loadScreen("/views/view_reports.fxml", "View Reports");
    }

    @FXML
    public void handleManageReservations() {
        loadScreen("/views/manage_reservations.fxml", "Manage Reservations");
    }

    @FXML
    public void handleLogout() {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.close();
        showAlert("Logout", "You have been logged out successfully.");
    }

    private void loadScreen(String fxmlPath, String title) {
        try {
            Stage stage = (Stage) manageUsersButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Failed to load the screen: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
