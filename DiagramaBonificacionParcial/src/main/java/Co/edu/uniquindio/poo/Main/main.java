package Co.edu.uniquindio.poo.Main;
import Co.edu.uniquindio.poo.Model.*;
import java.util.Date;

public class main {

    static void main(String[] args) {
        Empresa miEmpresa = new Empresa("Logistica Alimentaria S.A.");
        Proveedor provCentral = new Proveedor("Distribuidora Mayorista");
        miEmpresa.agregarProveedor(provCentral);
        Date inicioAnio = new Date(124, 0, 1);
        Date finAnio = new Date(124, 11, 31);
        Date fechaVenc = new Date(125, 5, 15);
        Date fechaEnv = new Date(123, 10, 10);
        Date fechaExpirada = new Date(120, 0, 1);
        Descuento diezPorciento = new Descuento(10.0,
                inicioAnio, finAnio);
        Descuento veintePorciento = new Descuento(20.0,
                fechaExpirada, inicioAnio);
        ProductoPerecedero leche = new ProductoPerecedero(
                "PER-01", "Leche 1L", 1000.0,
                "Distribuidora Mayorista",
                diezPorciento, fechaVenc
        );
        ProductoRefrigerado carne = new ProductoRefrigerado(
                "REF-02", "Lomo Fino", 2000.0,
                "Distribuidora Mayorista",
                veintePorciento, "INV-777", 8.0
        );
        ProductoEnvasado atun = new ProductoEnvasado(
                "ENV-03", "Atun VanCamps", 500.0,
                "Distribuidora Mayorista",
                null, fechaEnv, 200.0, PaisOrigen.colombia
        );
        MedicamentoFarmologico insulina = new MedicamentoFarmologico("MED-50",
                "Insulina Humana");
        provCentral.agregarProducto(leche);
        provCentral.agregarProducto(carne);
        provCentral.agregarProducto(atun);
        System.out.println("EMPRESA: " + miEmpresa.getNombre() + "");
        System.out.println("Proveedor: " + provCentral.getNombre());
        System.out.println("\nINTERFAZ REFRIGERABLE ");
        insulina.iniciarRefrigeracion();
        carne.iniciarRefrigeracion();
        System.out.println("\n PRUEBA DE LOGICA DE PRECIOS ");
        System.out.println("1. " + leche.getClass().getSimpleName() + " (Con Descuento Vigente)");
        System.out.println("   Precio Venta: $" + leche.calcularPrecioVenta());
        System.out.println("   Precio Final: $" + leche.calcularPrecioDescuento());
        System.out.println("\n2. " + carne.getClass().getSimpleName() + " (Con Descuento Vencido)");
        System.out.println("   Precio Venta: $" + carne.calcularPrecioVenta());
        System.out.println("   Precio Final: $" + carne.calcularPrecioDescuento());
        System.out.println("\n3. " + atun.getClass().getSimpleName() + " (Sin Descuento)");
        System.out.println("   Precio Venta: $" + atun.calcularPrecioVenta());
        System.out.println("   Precio Final: $" + atun.calcularPrecioDescuento());
    }
}