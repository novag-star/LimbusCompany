package Model;

public record resumenPago(String documento, String nombre, String tipoEmpleado,
        float salarioBruto, float descuentos, float salarioNeto) {
    @Override
    public String toString() {
        return String.format("Documento: %s | Nombre: %s | Tipo: %s\nBruto: $%.2f | Descuentos: $%.2f | Neto: $%.2f\n",
                documento, nombre, tipoEmpleado, salarioBruto, descuentos, salarioNeto);
    }
}