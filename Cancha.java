public class Cancha {
    private int id;
    private String nombre;
    private double precioPorHora;

    public Cancha(int id, String nombre, double precioPorHora) {
        this.id = id;
        this.nombre = nombre;
        this.precioPorHora = precioPorHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(double precioPorHora) {
        this.precioPorHora = precioPorHora;
    }
}
