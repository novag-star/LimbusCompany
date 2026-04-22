package Co.edu.uniquindio.poo.Model;

public class EmpleadoVentas extends Empleado {
    private float totalVentas;
    private float porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension, float totalVentas, float porcentajeComision) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        if (!(porcentajeComision < 0.0F) && !(porcentajeComision > 100.0F)) {
            this.totalVentas = totalVentas;
            this.porcentajeComision = porcentajeComision;
        } else {
            throw new IllegalArgumentException("El porcentaje de comisión debe estar entre 0 y 100.");
        }
    }

    public float calcularSalarioBruto() {
        float comision = this.totalVentas * (this.porcentajeComision / 100.0F);
        return this.salarioBase + this.calcularBonificacionCategoria() + comision;
    }
}
