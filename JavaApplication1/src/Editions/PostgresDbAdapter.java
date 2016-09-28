package Editions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Database connection adapter.
 */
public class PostgresDbAdapter {
    private final Connection connection;
    private static final PostgresDbAdapter adapter = new PostgresDbAdapter();
    
    private PostgresDbAdapter() {
        String connectionString = "jdbc:postgresql://localhost:5432/air"; 
        Connection c = null;
        
        try {
            c = DriverManager.getConnection(connectionString, "postgres", "74hr65jf8r");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        connection = c;
    }
    
    public static PostgresDbAdapter getAdapter() {
        return adapter;
    }
    
    public ResultSet executeQueryWithResult(String query) throws SQLException {
        Statement statement = connection.createStatement(); 
        return statement.executeQuery(query);
    }
    
    public void executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
    }
}
