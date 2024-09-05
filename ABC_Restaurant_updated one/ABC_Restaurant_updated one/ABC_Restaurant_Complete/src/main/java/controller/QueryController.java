
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Query;
import service.QueryService;

import java.sql.SQLException;

public class QueryController {
    @FXML
    private TextField userIdField;
    @FXML
    private TextField queryTextField;
    @FXML
    private TextField responseTextField;
    @FXML
    private TextField statusField;

    private QueryService queryService = new QueryService();

    @FXML
    private void addQuery() {
        try {
            int userId = Integer.parseInt(userIdField.getText());
            String queryText = queryTextField.getText();
            String responseText = responseTextField.getText();
            String status = statusField.getText();
            Query query = new Query(0, userId, queryText, responseText, status);
            queryService.saveQuery(query);
            showAlert("Success", "Query added successfully.");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to add query.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
