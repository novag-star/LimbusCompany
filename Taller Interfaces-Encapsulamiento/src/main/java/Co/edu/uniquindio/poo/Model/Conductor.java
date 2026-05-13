package Co.edu.uniquindio.poo.Model;
import java.time.LocalDate;
import java.util.List;

public record Conductor(
        String nombre,
        String apellidos,
        int documento,
        LocalDate fechaNacimiento,
        List<Vehiculo> listaVehiculos
){

}