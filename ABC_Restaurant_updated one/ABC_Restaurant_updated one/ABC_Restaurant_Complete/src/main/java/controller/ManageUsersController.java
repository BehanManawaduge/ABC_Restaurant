package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.User;
import service.UserService;

public class ManageUsersController {

    @FXML
    private TableView<User> usersTable;

    @FXML
    private TableColumn<User, Integer> userIdColumn;

    @FXML
    private TableColumn<User, String> usernameColumn;

    @FXML
    private TableColumn<User, String> roleColumn;

    @FXML
    private Button addUserButton;

    @FXML
    private Button deleteUserButton;

    private UserService userService = new UserService();

    @FXML
    public void initialize() {
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        loadUsers();
    }

    private void loadUsers() {
        ObservableList<User> usersList = FXCollections.observableArrayList(userService.getAllUsers());
        usersTable.setItems(usersList);
    }

    @FXML
    public void handleAddUser() {
        showAlert("Add User", "Add User button clicked.");
        loadUsers();
    }

    @FXML
    public void handleDeleteUser() {
        User selectedUser = usersTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            userService.deleteUser(selectedUser.getUserId());
            showAlert("Delete User", "User deleted successfully.");
            loadUsers();
        } else {
            showAlert("Error", "Please select a user to delete.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
