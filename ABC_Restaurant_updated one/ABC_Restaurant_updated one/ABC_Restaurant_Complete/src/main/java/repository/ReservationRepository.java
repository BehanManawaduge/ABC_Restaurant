package repository;

import model.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {

    private Connection connection;

    public ReservationRepository() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void saveReservation(Reservation reservation) throws SQLException {
        String query = "INSERT INTO reservations (service_type, reservation_date, details, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, reservation.getServiceType());
            stmt.setString(2, reservation.getReservationDate());
            stmt.setString(3, reservation.getDetails());
            stmt.setString(4, reservation.getStatus());
            stmt.executeUpdate();
        }
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservations";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int reservationId = rs.getInt("reservation_id");
                String serviceType = rs.getString("service_type");
                String reservationDate = rs.getString("reservation_date");
                String details = rs.getString("details");
                String status = rs.getString("status");
                reservations.add(new Reservation(reservationId, serviceType, reservationDate, details, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public void deleteReservation(int reservationId) {
        String query = "DELETE FROM reservations WHERE reservation_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, reservationId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
