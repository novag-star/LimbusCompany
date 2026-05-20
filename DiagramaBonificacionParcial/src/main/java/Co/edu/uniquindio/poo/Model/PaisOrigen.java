package Co.edu.uniquindio.poo.Model;

public enum PaisOrigen {
    colombia(0),
    argentina(1),
    chile(2),
    ecuador(3),
    peru(4);


    private final int valor;
    PaisOrigen(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return valor;
    }
}