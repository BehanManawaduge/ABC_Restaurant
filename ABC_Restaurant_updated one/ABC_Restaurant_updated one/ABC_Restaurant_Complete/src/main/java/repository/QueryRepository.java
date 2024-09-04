
package repository;

import model.Query;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryRepository {
    public List<Query> getAllQueries() throws SQLException {
        List<Query> queries = new ArrayList<>();
        String query = "SELECT * FROM queries";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Query queryObj = new Query(rs.getInt("query_id"), rs.getInt("user_id"), rs.getString("query_text"),
                        rs.getString("response_text"), rs.getString("status"));
                queries.add(queryObj);
            }
        }
        return queries;
    }

    public void saveQuery(Query query) throws SQLException {
        String querySQL = "INSERT INTO queries (user_id, query_text, response_text, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(querySQL)) {
            pstmt.setInt(1, query.getUserId());
            pstmt.setString(2, query.getQueryText());
            pstmt.setString(3, query.getResponseText());
            pstmt.setString(4, query.getStatus());
            pstmt.executeUpdate();
        }
    }
}
