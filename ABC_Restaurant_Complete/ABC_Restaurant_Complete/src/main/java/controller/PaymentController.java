
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Payment;
import service.PaymentService;

import java.sql.SQLException;

public class PaymentController {
    @FXML
    private TextField userIdField;
    @FXML
    private TextField reservationIdField;
    @FXML
    private TextField amountField;
    @FXML
    private TextField paymentMethodField;

    private PaymentService paymentService = new PaymentService();

    @FXML
    private void processPayment() {
        try {
            int userId = Integer.parseInt(userIdField.getText());
            int reservationId = Integer.parseInt(reservationIdField.getText());
            double amount = Double.parseDouble(amountField.getText());
            String paymentMethod = paymentMethodField.getText();
            Payment payment = new Payment(0, userId, reservationId, amount, "2023-01-01", paymentMethod);
            paymentService.savePayment(payment);
            showAlert("Success", "Payment processed successfully.");
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to process payment.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
