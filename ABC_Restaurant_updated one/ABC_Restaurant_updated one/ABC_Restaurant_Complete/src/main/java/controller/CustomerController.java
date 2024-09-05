package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Reservation;
import service.ReservationService;

import java.sql.SQLException;

public class CustomerController {

    @FXML
    private TextField reservationDetailsField;

    private ReservationService reservationService = new ReservationService();

    @FXML
    private void makeReservation() {
        String details = reservationDetailsField.getText();
        Reservation reservation = new Reservation(0, "Dine-in", "2024-09-03", details, "Pending");

        try {
            reservationService.saveReservation(reservation);
            showAlert("Success", "Reservation made successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to make a reservation.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
