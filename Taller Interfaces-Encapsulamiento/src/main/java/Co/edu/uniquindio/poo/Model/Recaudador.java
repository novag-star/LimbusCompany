package Co.edu.uniquindio.poo.Model;
import java.time.LocalDate;

public class Recaudador implements EntidadCobradora {
    private String nombre;
    private String apellidos;
    private int documentoIdentidad;
    private LocalDate fechaNacimiento;
    private int sueldoMensual;

    public Recaudador(String nombre, String apellidos, int documentoIdentidad, LocalDate fechaNacimiento, int sueldoMensual) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documentoIdentidad = documentoIdentidad;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public void cobrarPeaje(Vehiculo vehiculo) {
        int valorCobrado = vehiculo.calcularPeaje();
        vehiculo.setNumeroPeajesPagados(vehiculo.getNumeroPeajesPagados() + 1);
        System.out.println("Recaudador " + nombre + " cobró: $" + valorCobrado);
    }
}