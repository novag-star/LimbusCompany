package Co.edu.uniquindio.poo.Model;

public class Camion extends Vehiculo {
    private int capacidadCarga;
    private int numeroEjes;

    public Camion(String placa, int numeroPeajesPagados, int capacidadCarga, int numeroEjes) {
        super(placa, numeroPeajesPagados);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }

    @Override
    public int calcularPeaje() {
        double valorBase = 7000 * numeroEjes;
        if (capacidadCarga > 10) {
            valorBase += valorBase * 0.10;
        }
        return (int) valorBase;
    }

    public int getCapacidadCarga() { return capacidadCarga; }
}