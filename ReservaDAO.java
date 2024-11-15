import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReservaDAO {
    private Connection connection;

    public ReservaDAO() {
        try {
            // Cargar propiedades de conexión desde el archivo db.properties
            Properties properties = new Properties();
            properties.load(new FileInputStream("db.properties"));

            // Obtener los datos de conexión de las propiedades
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            // Establecer la conexión con la base de datos
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión establecida exitosamente.");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar el archivo de propiedades.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al establecer la conexión con la base de datos.");
        }
    }

    // Método para crear una reserva
    public void crearReserva(Reserva reserva) {
        String sql = "INSERT INTO reservas (id_cliente, id_cancha, fecha, horas_alquiler) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reserva.getIdCliente());
            statement.setInt(2, reserva.getIdCancha());
            statement.setDate(3, new java.sql.Date(reserva.getFechaReserva().getTime()));
            statement.setInt(4, reserva.getHorasAlquiladas());

            statement.executeUpdate();
            System.out.println("Reserva creada exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al crear la reserva.");
        }
    }

    // Método para leer todas las reservas
    public List<Reserva> listarReservas() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservas";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            Reserva reserva = new Reserva(
                    resultSet.getInt("id"),
                    resultSet.getInt("id_cliente"),
                    resultSet.getInt("id_cancha"),
                    resultSet.getInt("horas_alquiler"),
                    resultSet.getDate("fecha")
            );
            reservas.add(reserva);

            System.out.println("Reservas leídas exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al leer las reservas.");
        }

        return reservas;
    }

    // Método para actualizar una reserva
    public void actualizarReserva(Reserva reserva) {
        String sql = "UPDATE reservas SET id_cliente = ?, id_cancha = ?, fecha = ?, horas_alquiler = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reserva.getIdCliente());
            statement.setInt(2, reserva.getIdCancha());
            statement.setDate(3, new java.sql.Date(reserva.getFechaReserva().getTime()));
            statement.setInt(4, reserva.getHorasAlquiladas());
            statement.setInt(5, reserva.getId());

            statement.executeUpdate();
            System.out.println("Reserva actualizada exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar la reserva.");
        }
    }

    // Método para eliminar una reserva
    public void eliminarReserva(int id) {
        String sql = "DELETE FROM reservas WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Reserva eliminada exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al eliminar la reserva.");
        }
    }
}

