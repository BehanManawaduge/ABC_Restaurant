
package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Admin;
import service.AdminService;

import java.sql.SQLException;
import java.util.List;

public class AdminController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField contactInfoField;
    @FXML
    private TextField emailField;
    @FXML
    private TableView<Admin> adminTable;

    private AdminService adminService = new AdminService();
    private ObservableList<Admin> adminList;

    @FXML
    private void initialize() {
        try {
            List<Admin> admins = adminService.getAllAdmins();
            adminList = FXCollections.observableArrayList(admins);
            adminTable.setItems(adminList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addAdmin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String contactInfo = contactInfoField.getText();
        String email = emailField.getText();

        Admin admin = new Admin(0, username, password, "Admin", contactInfo, email);
        try {
            adminService.registerAdmin(admin);
            adminList.add(admin);
            clearFields();
        } catch (SQLException e) {
            showAlert("Error", "Could not add admin");
            e.printStackTrace();
        }
    }

    private void clearFields() {
        usernameField.clear();
        passwordField.clear();
        contactInfoField.clear();
        emailField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
