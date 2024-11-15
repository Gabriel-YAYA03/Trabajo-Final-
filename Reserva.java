import java.util.Date;

public class Reserva {
    private int id;
    private int idCliente;
    private int idCancha;
    private int horasAlquiladas;
    private Date fechaReserva;

    public Reserva(int id, int idCliente, int idCancha, int horasAlquiladas, Date fechaReserva) {
        this.id = id;
        this.idCliente = idCliente;
        this.idCancha = idCancha;
        this.horasAlquiladas = horasAlquiladas;
        this.fechaReserva = fechaReserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(int idCancha) {
        this.idCancha = idCancha;
    }

    public int getHorasAlquiladas() {
        return horasAlquiladas;
    }

    public void setHorasAlquiladas(int horasAlquiladas) {
        this.horasAlquiladas = horasAlquiladas;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}

