package model;

public class Tarea {

    private String codigo;
    private String descripcionTareas;

    public Tarea(String codigo, String descripcionTareas) {
        this.codigo = codigo;
        this.descripcionTareas = descripcionTareas;
    }

    public String obtenerDetalles() {
        return "Codigo: " + codigo +
                ", Descripcion: " + descripcionTareas;
    }

}