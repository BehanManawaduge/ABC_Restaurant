
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import model.Reservation;
import service.ReservationController;

import java.sql.SQLException;
import java.util.List;

public class StaffController {
    @FXML
    private TableView<Reservation> reservationTable;

    private ReservationController reservationController = new ReservationController();

    @FXML
    private void initialize() {
        List<Reservation> reservations = reservationController.getAllReservations();
        reservationTable.getItems().setAll(reservations);
    }

    @FXML
    private void updateReservationStatus() {
        // Logic to update reservation status
        showAlert("Success", "Reservation status updated");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
