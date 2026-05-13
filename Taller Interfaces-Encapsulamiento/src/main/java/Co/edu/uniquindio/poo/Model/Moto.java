package Co.edu.uniquindio.poo.Model;

public class Moto extends Vehiculo {
    private int cilindrajeMoto;

    public Moto(String placa, int numeroPeajesPagados, int cilindrajeMoto) {
        super(placa, numeroPeajesPagados);
        this.cilindrajeMoto = cilindrajeMoto;
    }

    @Override
    public int calcularPeaje() {
        int valorBase = 5000;
        if (cilindrajeMoto > 200) {
            valorBase += 2000;
        }
        return valorBase;
    }
}