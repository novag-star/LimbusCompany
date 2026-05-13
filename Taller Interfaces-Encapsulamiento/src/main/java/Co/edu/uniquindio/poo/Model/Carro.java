package Co.edu.uniquindio.poo.Model;

public class Carro extends Vehiculo {
    private boolean esElectrico;
    private boolean esServicioPublico;

    public Carro(String placa, int numeroPeajesPagados, boolean esElectrico, boolean esServicioPublico) {
        super(placa, numeroPeajesPagados);
        this.esElectrico = esElectrico;
        this.esServicioPublico = esServicioPublico;
    }

    @Override
    public int calcularPeaje() {
        double valorBase = 10000;
        if (esElectrico) valorBase -= 10000 * 0.20;
        if (esServicioPublico) valorBase += 10000 * 0.15;
        return (int) valorBase;
    }
}
