import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    public void agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO Clientes (nombre, telefono, correo) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getCorreo());
            pstmt.executeUpdate();
            System.out.println("Cliente agregado exitosamente.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("correo")
                );
                clientes.add(cliente);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void actualizarCliente(Cliente cliente) {
        String sql = "UPDATE Clientes SET nombre = ?, telefono = ?, correo = ? WHERE id_cliente = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getCorreo());
            pstmt.setInt(4, cliente.getId());
            pstmt.executeUpdate();
            System.out.println("Cliente actualizado exitosamente.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCliente(int id) {
        String sql = "DELETE FROM Clientes WHERE id_cliente = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Cliente eliminado exitosamente.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

