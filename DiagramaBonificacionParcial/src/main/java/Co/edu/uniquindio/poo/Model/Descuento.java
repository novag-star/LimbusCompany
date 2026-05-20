package Co.edu.uniquindio.poo.Model;
import java.util.Date;

public class Descuento {
    private double porcentaje;
    private Date fechaInicio;
    private Date fechaFin;

    public Descuento(double porcentaje, Date fechaInicio, Date fechaFin) {
        this.porcentaje = porcentaje;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters
    public double getPorcentaje() { return porcentaje; }
    public Date getFechaInicio() { return fechaInicio; }
    public Date getFechaFin() { return fechaFin; }
}

