import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PSQLConnect {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/crud";
        String username = "crud";
        String password = "crud";
        Connection connection = null;
        
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
