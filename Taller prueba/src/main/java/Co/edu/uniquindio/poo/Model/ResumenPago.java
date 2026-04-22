package Co.edu.uniquindio.poo.Model;

public record ResumenPago(String documento, String nombre, String tipoEmpleado, float salarioBruto, float descuentos, float salarioNeto) {
    public String toString() {
        return String.format("Documento: %s | Nombre: %s | Tipo: %s\nBruto: $%.2f | Descuentos: $%.2f | Neto: $%.2f\n", this.documento, this.nombre, this.tipoEmpleado, this.salarioBruto, this.descuentos, this.salarioNeto);
    }
}
