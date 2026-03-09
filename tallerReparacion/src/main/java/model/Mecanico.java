package model;

public class Mecanico {

    private String codigoMecanico;
    private String nombreMecanico;

    public Mecanico(String codigoMecanico, String nombreMecanico) {
        this.codigoMecanico = codigoMecanico;
        this.nombreMecanico = nombreMecanico;
    }

    public String obtenerDetalles() {
        return "Codigo: " + codigoMecanico +
                ", Nombre: " + nombreMecanico;
    }

}