package Co.edu.uniquindio.poo.Model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EstacionPeaje implements EntidadCobradora {
    private String nombre;
    private String departamento;
    private int valorNumerico;
    private List<RegistroPeaje> listaRegistrosPeajes;

    public EstacionPeaje(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.valorNumerico = 0;
        this.listaRegistrosPeajes = new ArrayList<>();
    }

    @Override
    public void cobrarPeaje(Vehiculo vehiculo) {
        int valorCobrado = vehiculo.calcularPeaje();
        this.valorNumerico += valorCobrado;
        vehiculo.setNumeroPeajesPagados(vehiculo.getNumeroPeajesPagados() + 1);

        RegistroPeaje registro = new RegistroPeaje(vehiculo, valorCobrado, LocalDateTime.now());
        listaRegistrosPeajes.add(registro);
    }

    public int getValorNumerico() { return valorNumerico; }
}