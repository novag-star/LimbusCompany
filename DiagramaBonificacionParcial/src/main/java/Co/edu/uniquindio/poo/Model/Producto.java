package Co.edu.uniquindio.poo.Model;

import java.util.Date;

public abstract class Producto {
    private String codigo;
    private String nombre;
    private double precioCompra;
    private String proveedor; // Mantenido por ser estricto al diagrama
    private Descuento descuento; // Mantenido como atributo según la caja UML

    public Producto(String codigo, String nombre, double precioCompra, String proveedor, Descuento descuento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.proveedor = proveedor;
        this.descuento = descuento;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    // Método abstracto para que cada hijo implemente su propia regla de negocio
    public abstract double calcularPrecioVenta();

    // Cálculo general del descuento basado en las fechas
    public double calcularPrecioDescuento() {
        double precioVentaBase = calcularPrecioVenta();

        if (descuento != null) {
            Date fechaActual = new Date();
            // Lógica del enunciado: if (fecha.after(fechaInicio) && fecha.before(fechaFin))
            if (fechaActual.after(descuento.getFechaInicio()) && fechaActual.before(descuento.getFechaFin())) {
                double valorDescontado = precioVentaBase * (descuento.getPorcentaje() / 100.0);
                return precioVentaBase - valorDescontado;
            }
        }
        return precioVentaBase; // Si no hay descuento vigente, retorna precio normal
    }
}