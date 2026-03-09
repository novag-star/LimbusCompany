package model;

public class Repuesto {

    private String nombre;
    private int cantidad;
    private double costo;
    private String codigo;

    public Repuesto(String nombre, int cantidad, double costo, String codigo) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
        this.codigo = codigo;
    }

    public String obtenerDetalles() {
        return "Codigo: " + codigo +
                ", Nombre: " + nombre +
                ", Cantidad: " + cantidad +
                ", Costo: " + costo;
    }
    public double getCosto() {
        return costo;
    }

    public int getCantidad() {
        return cantidad;
    }

}