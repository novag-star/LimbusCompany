package Co.edu.uniquindio.poo.Model;
import java.util.ArrayList;
import java.util.List;

public class EmpresaPeaje {
    private String nombre;
    private List<EstacionPeaje> listaEstacionesPeajes;
    private List<Vehiculo> listaVehiculos;
    private List<Recaudador> listaRecaudadores;

    public EmpresaPeaje(String nombre) {
        this.nombre = nombre;
        this.listaEstacionesPeajes = new ArrayList<>();
        this.listaVehiculos = new ArrayList<>();
        this.listaRecaudadores = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo v) {
        listaVehiculos.add(v);
    }

    public List<Camion> obtenerCamionesEspecificos() {
        List<Camion> camionesFiltrados = new ArrayList<>();
        for (Vehiculo v : listaVehiculos) {
            if (v instanceof Camion) {
                Camion c = (Camion) v;
                if (c.getCapacidadCarga() > 10 && c.getNumeroPeajesPagados() > 5) {
                    camionesFiltrados.add(c);
                }
            }
        }
        return camionesFiltrados;
    }
}