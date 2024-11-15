import java.util.Scanner;
import java.util.Date;
import java.util.List;

public class MainMenu {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        CanchaDAO canchaDAO = new CanchaDAO();
        ReservaDAO reservaDAO = new ReservaDAO();
        PagoDAO pagoDAO = new PagoDAO();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Canchas");
            System.out.println("3. Gestionar Reservas");
            System.out.println("4. Gestionar Pagos");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea

            switch (opcion) {
                case 1:
                    gestionarClientes(clienteDAO, scanner);
                    break;
                case 2:
                    gestionarCanchas(canchaDAO, scanner);
                    break;
                case 3:
                    gestionarReservas(reservaDAO, scanner);
                    break;
                case 4:
                    gestionarPagos(scanner, pagoDAO);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void gestionarClientes(ClienteDAO clienteDAO, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();
                    Cliente nuevoCliente = new Cliente(0, nombre, telefono, correo);
                    clienteDAO.agregarCliente(nuevoCliente);
                    break;
                case 2:
                    for (Cliente cliente : clienteDAO.listarClientes()) {
                        System.out.println("ID: " + cliente.getId() + ", Nombre: " + cliente.getNombre() + ", Teléfono: " + cliente.getTelefono() + ", Correo: " + cliente.getCorreo());
                    }
                    break;
                case 3:
                    System.out.print("ID del Cliente a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir la línea
                    System.out.print("Nuevo Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Nuevo Teléfono: ");
                    telefono = scanner.nextLine();
                    System.out.print("Nuevo Correo: ");
                    correo = scanner.nextLine();
                    Cliente clienteActualizado = new Cliente(idActualizar, nombre, telefono, correo);
                    clienteDAO.actualizarCliente(clienteActualizado);
                    break;
                case 4:
                    System.out.print("ID del Cliente a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    clienteDAO.eliminarCliente(idEliminar);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);
    }

    private static void gestionarCanchas(CanchaDAO canchaDAO, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Canchas ---");
            System.out.println("1. Agregar Cancha");
            System.out.println("2. Listar Canchas");
            System.out.println("3. Actualizar Cancha");
            System.out.println("4. Eliminar Cancha");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la cancha: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio por hora: ");
                    double precio = scanner.nextDouble();
                    Cancha nuevaCancha = new Cancha(0, nombre, precio);
                    canchaDAO.crearCancha(nuevaCancha);
                    break;
                case 2:
                    for (Cancha cancha : canchaDAO.listarCanchas()) {
                        System.out.println("ID: " + cancha.getId() + ", Nombre: " + cancha.getNombre() + ", Precio por hora: " + cancha.getPrecioPorHora());
                    }
                    break;
                case 3:
                    System.out.print("ID de la Cancha a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir la línea
                    System.out.print("Nuevo Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Nuevo Precio por hora: ");
                    precio = scanner.nextDouble();
                    Cancha canchaActualizada = new Cancha(idActualizar, nombre, precio);
                    canchaDAO.actualizarCancha(canchaActualizada);
                    break;
                case 4:
                    System.out.print("ID de la Cancha a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    canchaDAO.eliminarCancha(idEliminar);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);
    }

    private static void gestionarReservas(ReservaDAO reservaDAO, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Reservas ---");
            System.out.println("1. Agregar Reserva");
            System.out.println("2. Listar Reservas");
            System.out.println("3. Actualizar Reserva");
            System.out.println("4. Eliminar Reserva");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la línea

            switch (opcion) {
                case 1:
                    System.out.print("ID del Cliente: ");
                    int idCliente = scanner.nextInt();
                    System.out.print("ID de la Cancha: ");
                    int idCancha = scanner.nextInt();
                    System.out.print("Horas alquiladas: ");
                    int horas = scanner.nextInt();
                    Reserva nuevaReserva = new Reserva(0, idCliente, idCancha, horas, null);
                    reservaDAO.crearReserva(nuevaReserva);
                    break;
                case 2:
                    for (Reserva reserva : reservaDAO.listarReservas()) {
                        System.out.println("ID: " + reserva.getId() + ", ID Cliente: " + reserva.getIdCliente() + ", ID Cancha: " + reserva.getIdCancha() + ", Horas alquiladas: " + reserva.getHorasAlquiladas() + ", Fecha: " + reserva.getFechaReserva());
                    }
                    break;
                case 3:
                    System.out.print("ID de la Reserva a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    System.out.print("Nuevo ID del Cliente: ");
                    idCliente = scanner.nextInt();
                    System.out.print("Nuevo ID de la Cancha: ");
                    idCancha = scanner.nextInt();
                    System.out.print("Nuevas Horas alquiladas: ");
                    horas = scanner.nextInt();
                    Reserva reservaActualizada = new Reserva(idActualizar, idCliente, idCancha, horas, null);
                    reservaDAO.actualizarReserva(reservaActualizada);
                    break;
                case 4:
                    System.out.print("ID de la Reserva a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    reservaDAO.eliminarReserva(idEliminar);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);
    }

    public static void gestionarPagos(Scanner scanner, PagoDAO pagoDAO) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Pagos ---");
            System.out.println("1. Crear Pago");
            System.out.println("2. Listar Pagos");
            System.out.println("3. Actualizar Pago");
            System.out.println("4. Eliminar Pago");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("ID de la Reserva: ");
                    int idReserva = scanner.nextInt();
                    System.out.print("Monto: ");
                    double monto = scanner.nextDouble();
                    Date fechaPago = new Date(); // Fecha actual
                    Pago nuevoPago = new Pago(0, idReserva, monto, fechaPago);
                    pagoDAO.crearPago(nuevoPago);
                    break;
                case 2:
                    List<Pago> pagos = pagoDAO.listarPagos();
                    for (Pago pago : pagos) {
                        System.out.println("ID: " + pago.getId() + ", ID Reserva: " + pago.getIdReserva() + ", Monto: " + pago.getMonto() + ", Fecha de pago: " + pago.getFechaPago());
                    }
                    break;
                case 3:
                    System.out.print("ID del Pago a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    System.out.print("Nuevo ID de la Reserva: ");
                    idReserva = scanner.nextInt();
                    System.out.print("Nuevo Monto: ");
                    monto = scanner.nextDouble();
                    Pago pagoActualizado = new Pago(idActualizar, idReserva, monto, new Date());
                    pagoDAO.actualizarPago(pagoActualizado);
                    break;
                case 4:
                    System.out.print("ID del Pago a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    pagoDAO.eliminarPago(idEliminar);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);
    }
}
