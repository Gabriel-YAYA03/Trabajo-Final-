import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class PagoDAO {
    public List<Pago> listarPagos() {
        List<Pago> pagos = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Pagos")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int idReserva = rs.getInt("id_reserva");
                double monto = rs.getDouble("monto");
                Date fechaPago = rs.getDate("fecha_pago");

                pagos.add(new Pago(id, idReserva, monto, fechaPago));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace(); // Manejo combinado de las excepciones
        }
        return pagos;
    }

    public void crearPago(Pago pago) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Pagos (id_reserva, monto, fecha_pago) VALUES (?, ?, ?)")) {

            stmt.setInt(1, pago.getIdReserva());
            stmt.setDouble(2, pago.getMonto());
            stmt.setDate(3, new java.sql.Date(pago.getFechaPago().getTime()));
            stmt.executeUpdate();
            System.out.println("Pago creado con éxito.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPago(Pago pago) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE Pagos SET id_reserva = ?, monto = ?, fecha_pago = ? WHERE id = ?")) {

            stmt.setInt(1, pago.getIdReserva());
            stmt.setDouble(2, pago.getMonto());
            stmt.setDate(3, new java.sql.Date(pago.getFechaPago().getTime()));
            stmt.setInt(4, pago.getId());
            stmt.executeUpdate();
            System.out.println("Pago actualizado con éxito.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPago(int id) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Pagos WHERE id = ?")) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Pago eliminado con éxito.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
