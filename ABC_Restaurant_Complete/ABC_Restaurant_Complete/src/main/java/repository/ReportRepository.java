package repository;

import model.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportRepository {

    private Connection connection;

    public ReportRepository() {
        this.connection = DatabaseConnection.getConnection();
    }

    public List<Report> getAllReports() {
        List<Report> reports = new ArrayList<>();
        String query = "SELECT * FROM reports";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int reportId = rs.getInt("report_id");
                String reportType = rs.getString("report_type");
                String reportContent = rs.getString("report_content");
                reports.add(new Report(reportId, reportType, reportContent));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }
}
