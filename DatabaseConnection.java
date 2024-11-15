import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException, IOException {
        Properties properties = new Properties();

        // Ruta al archivo de propiedades
        String path = "db.properties";
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
        }

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        // Establecer conexión
        return DriverManager.getConnection(url, user, password);
    }
}
