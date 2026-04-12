package Model;

import java.time.LocalTime;

public class Empleado {
    // Atributos L
    private String nombre;
    private String cedula;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;

    // Constructor
    public Empleado(String nombre, String cedula, LocalTime horaEntrada, LocalTime horaSalida) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }


    public boolean llegoTarde(LocalTime horaEntradaEmpresa) {
        boolean resultado = false;

        if (this.horaEntrada.isAfter(horaEntradaEmpresa)) {
            resultado = true;
        }

        return resultado;
    }
    public String getNombre() {
        return nombre;
    }
    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }
}