package Co.edu.uniquindio.poo.Model;

import java.util.Date;

public class ProductoEnvasado extends Producto {
    private Date fechaEnvasado;
    private double pesoGramos;
    private PaisOrigen paisOrigen;

    public ProductoEnvasado(String codigo, String nombre, double precioCompra, String proveedor, Descuento descuento, Date fechaEnvasado, double pesoGramos, PaisOrigen paisOrigen) {
        super(codigo, nombre, precioCompra, proveedor, descuento);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoGramos = pesoGramos;
        this.paisOrigen = paisOrigen;
    }

    @Override
    public double calcularPrecioVenta() {
        // Utilidad de $300 por cada gramo de peso
        return getPrecioCompra() + (300.0 * pesoGramos);
    }
}