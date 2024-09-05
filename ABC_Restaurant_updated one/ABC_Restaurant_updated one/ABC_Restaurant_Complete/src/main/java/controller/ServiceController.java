
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Service;
import service.ServiceService;

import java.sql.SQLException;

public class ServiceController {
    @FXML
    private TextField serviceNameField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField priceField;

    private ServiceService serviceService = new ServiceService();

    @FXML
    private void addService() {
        try {
            String serviceName = serviceNameField.getText();
            String description = descriptionField.getText();
            double price = Double.parseDouble(priceField.getText());
            Service service = new Service(0, serviceName, description, price);
            serviceService.saveService(service);
            showAlert("Success", "Service added successfully.");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to add service.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
