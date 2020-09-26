package WowMarket;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WowDB {
    final String JDBC_DRIVER = "org.postgresql.Driver";
    final String DB_URL = "jdbc:postgresql://localhost/wowdb";

    Connection conn = null;
    Statement stmt = null;

    String table_name;

    public void connect(String realm_name, String username, String password) throws SQLException, Exception {
        this.table_name = realm_name;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Map<String, Object>> getItem(int item_id) throws SQLException {
        ResultSet rs = null;
        List<Map<String, Object>> price_list = new ArrayList<>();
        try {
            if (!conn.isValid(0)) {
                throw new SQLException("Connection invalid.");
            }
            stmt = conn.createStatement();
            String sql = "SELECT date_trunc('minute', interval), quantity, avg_unit_price, high_price, low_price " +
                " FROM " + table_name +
                " WHERE item_id = " + item_id;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Timestamp timestamp = rs.getTimestamp("date_trunc");
                int quantity = rs.getInt("quantity");
                long avg_unit_price = rs.getLong("avg_unit_price");
                long high_price = rs.getLong("high_price");
                long low_price = rs.getLong("low_price");
                Map<String, Object> mp = new HashMap<>();
                mp.put("interval", timestamp);
                mp.put("quantity", quantity);
                mp.put("avg_unit_price", avg_unit_price);
                mp.put("high_price", high_price);
                mp.put("low_price", low_price);
                price_list.add(mp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            rs.close();
            stmt.close();
        }
        return price_list;
    }
}
