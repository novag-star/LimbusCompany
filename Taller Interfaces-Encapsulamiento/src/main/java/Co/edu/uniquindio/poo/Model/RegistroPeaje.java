package Co.edu.uniquindio.poo.Model;

import java.time.LocalDateTime;

public class RegistroPeaje {
    private Vehiculo vehiculo;
    private int valor;
    private LocalDateTime fecha;

    public RegistroPeaje(Vehiculo vehiculo, int valor, LocalDateTime fecha) {
        this.vehiculo = vehiculo;
        this.valor = valor;
        this.fecha = fecha;
    }

    public int getValor() { return valor; }
}