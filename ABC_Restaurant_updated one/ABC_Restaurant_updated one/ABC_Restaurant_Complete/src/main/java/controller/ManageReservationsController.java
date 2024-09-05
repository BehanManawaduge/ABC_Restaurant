package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Reservation;
import service.ReservationService;

public class ManageReservationsController {

    @FXML
    private TableView<Reservation> reservationsTable;

    @FXML
    private TableColumn<Reservation, Integer> reservationIdColumn;

    @FXML
    private TableColumn<Reservation, String> serviceTypeColumn;

    @FXML
    private TableColumn<Reservation, String> reservationDateColumn;

    @FXML
    private Button addReservationButton;

    @FXML
    private Button deleteReservationButton;

    private ReservationService reservationService = new ReservationService();

    @FXML
    public void initialize() {
        reservationIdColumn.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        serviceTypeColumn.setCellValueFactory(new PropertyValueFactory<>("serviceType"));
        reservationDateColumn.setCellValueFactory(new PropertyValueFactory<>("reservationDate"));
        loadReservations();
    }

    private void loadReservations() {
        ObservableList<Reservation> reservationsList = FXCollections.observableArrayList(reservationService.getAllReservations());
        reservationsTable.setItems(reservationsList);
    }

    @FXML
    public void handleAddReservation() {
        showAlert("Add Reservation", "Add Reservation button clicked.");
        loadReservations();
    }

    @FXML
    public void handleDeleteReservation() {
        Reservation selectedReservation = reservationsTable.getSelectionModel().getSelectedItem();
        if (selectedReservation != null) {
            reservationService.deleteReservation(selectedReservation.getReservationId());
            showAlert("Delete Reservation", "Reservation deleted successfully.");
            loadReservations();
        } else {
            showAlert("Error", "Please select a reservation to delete.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
