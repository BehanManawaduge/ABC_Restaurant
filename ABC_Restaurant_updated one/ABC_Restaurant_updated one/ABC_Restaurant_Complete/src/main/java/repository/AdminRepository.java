
package repository;

import model.Admin;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    public List<Admin> getAllAdmins() throws SQLException {
        List<Admin> admins = new ArrayList<>();
        String query = "SELECT * FROM users WHERE role = 'Admin'";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Admin admin = new Admin(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("role"), rs.getString("contact_info"), rs.getString("email"));
                admins.add(admin);
            }
        }
        return admins;
    }

    public void saveAdmin(Admin admin) throws SQLException {
        String query = "INSERT INTO users (username, password, role, contact_info, email) VALUES (?, ?, 'Admin', ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, admin.getUsername());
            pstmt.setString(2, admin.getPassword());
            pstmt.setString(3, admin.getContactInfo());
            pstmt.setString(4, admin.getEmail());
            pstmt.executeUpdate();
        }
    }
}
