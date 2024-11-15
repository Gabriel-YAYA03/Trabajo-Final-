import java.util.Date;
import java.util.Date;

public class Pago {
    private int id;
    private int idReserva;
    private double monto;
    private Date fechaPago;

    public Pago(int id, int idReserva, double monto, Date fechaPago) {
        this.id = id;
        this.idReserva = idReserva;
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public double getMonto() {
        return monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
}
