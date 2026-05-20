package Co.edu.uniquindio.poo.Model;

import java.util.Date;

public class ProductoPerecedero extends Producto {
    private Date fechaVencimiento;

    public ProductoPerecedero(String codigo, String nombre, double precioCompra, String proveedor, Descuento descuento, Date fechaVencimiento) {
        super(codigo, nombre, precioCompra, proveedor, descuento);
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public double calcularPrecioVenta() {
        // Utilidad del 35% sobre precio de compra
        return getPrecioCompra() + (getPrecioCompra() * 0.35);
    }
}