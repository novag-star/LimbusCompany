package Co.edu.uniquindio.poo.Model;

public abstract class Vehiculo {
    private String placa;
    private int numeroPeajesPagados;

    public Vehiculo(String placa, int numeroPeajesPagados) {
        this.placa = placa;
        this.numeroPeajesPagados = numeroPeajesPagados;
    }

    public abstract int calcularPeaje();

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public int getNumeroPeajesPagados() { return numeroPeajesPagados; }
    public void setNumeroPeajesPagados(int numeroPeajesPagados) { this.numeroPeajesPagados = numeroPeajesPagados; }
}