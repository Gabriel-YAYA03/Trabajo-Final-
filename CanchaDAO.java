import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CanchaDAO {
    private Connection connection;

    public CanchaDAO() {
        try {
            this.connection = DatabaseConnection.getConnection();  // Puede lanzar IOException
        } catch (SQLException | IOException e) { // Captura tanto SQLException como IOException
            e.printStackTrace();
        }
    }

    public void crearCancha(Cancha cancha) {
        String query = "INSERT INTO Canchas (nombre, precio_por_hora) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cancha.getNombre());
            statement.setDouble(2, cancha.getPrecioPorHora());
            statement.executeUpdate();
            System.out.println("Cancha creada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cancha> listarCanchas() {
        List<Cancha> canchas = new ArrayList<>();
        String query = "SELECT * FROM Canchas";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Cancha cancha = new Cancha(
                        resultSet.getInt("id_cancha"),
                        resultSet.getString("nombre"),
                        resultSet.getDouble("precio_por_hora")
                );
                canchas.add(cancha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return canchas;
    }

    public void actualizarCancha(Cancha cancha) {
        String query = "UPDATE Canchas SET nombre = ?, precio_por_hora = ? WHERE id_cancha = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, cancha.getNombre());
            statement.setDouble(2, cancha.getPrecioPorHora());
            statement.setInt(3, cancha.getId());
            statement.executeUpdate();
            System.out.println("Cancha actualizada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCancha(int idCancha) {
        String query = "DELETE FROM Canchas WHERE id_cancha = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idCancha);
            statement.executeUpdate();
            System.out.println("Cancha eliminada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


