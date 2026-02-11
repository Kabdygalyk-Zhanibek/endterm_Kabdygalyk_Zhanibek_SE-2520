package petterns;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static DatabaseManager instance;
    private Connection connection;

    private DatabaseManager() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/manga_list";
        String user = "postgres";
        String pass = "Janibek590!";
        this.connection = DriverManager.getConnection(url, user, pass);
    }

    public static synchronized DatabaseManager getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}