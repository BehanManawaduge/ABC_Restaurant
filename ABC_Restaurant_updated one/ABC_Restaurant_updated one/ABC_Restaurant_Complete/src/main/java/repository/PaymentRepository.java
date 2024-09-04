
package repository;

import model.Payment;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {
    public List<Payment> getAllPayments() throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT * FROM payments";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Payment payment = new Payment(rs.getInt("payment_id"), rs.getInt("user_id"),
                        rs.getInt("reservation_id"), rs.getDouble("amount"), rs.getString("payment_date"),
                        rs.getString("payment_method"));
                payments.add(payment);
            }
        }
        return payments;
    }

    public void savePayment(Payment payment) throws SQLException {
        String query = "INSERT INTO payments (user_id, reservation_id, amount, payment_date, payment_method) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, payment.getUserId());
            pstmt.setInt(2, payment.getReservationId());
            pstmt.setDouble(3, payment.getAmount());
            pstmt.setString(4, payment.getPaymentDate());
            pstmt.setString(5, payment.getPaymentMethod());
            pstmt.executeUpdate();
        }
    }
}
