package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Report;
import service.ReportService;

public class ViewReportsController {

    @FXML
    private TableView<Report> reportsTable;

    @FXML
    private TableColumn<Report, Integer> reportIdColumn;

    @FXML
    private TableColumn<Report, String> reportTypeColumn;

    @FXML
    private TableColumn<Report, String> reportContentColumn;

    @FXML
    private Button refreshButton;

    private ReportService reportService = new ReportService();

    @FXML
    public void initialize() {
        reportIdColumn.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        reportTypeColumn.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        reportContentColumn.setCellValueFactory(new PropertyValueFactory<>("reportContent"));
        loadReports();
    }

    private void loadReports() {
        ObservableList<Report> reportsList = FXCollections.observableArrayList(reportService.getAllReports());
        reportsTable.setItems(reportsList);
    }

    @FXML
    public void handleRefresh() {
        loadReports();
        showAlert("Refresh Reports", "Reports have been refreshed.");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
