package Co.edu.uniquindio.poo.Model;

public class ProductoRefrigerado extends Producto implements Refrigerable {
    private String codigoAprobacion;
    private double temperaturaRefrigerado;

    public ProductoRefrigerado(String codigo, String nombre, double precioCompra, String proveedor, Descuento descuento, String codigoAprobacion, double temperaturaRefrigerado) {
        super(codigo, nombre, precioCompra, proveedor, descuento);
        this.codigoAprobacion = codigoAprobacion;
        this.temperaturaRefrigerado = temperaturaRefrigerado;
    }

    @Override
    public double calcularPrecioVenta() {
        // Utilidad de $500 por cada grado de temperatura
        return getPrecioCompra() + (500.0 * temperaturaRefrigerado);
    }

    @Override
    public void iniciarRefrigeracion() {
        System.out.println("Iniciando refrigeración del producto alimenticio...");
    }
}