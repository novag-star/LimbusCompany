package Co.edu.uniquindio.poo.Model;

public class EmpleadoTemporal extends Empleado {
    private int diasTrabajados;
    private float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float descuentoSalud, float descuentoPension, int diasTrabajados, float valorDia) {
        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);
        if (diasTrabajados < 0) {
            throw new IllegalArgumentException("Los días trabajados no pueden ser negativos.");
        } else if (valorDia < 0.0F) {
            throw new IllegalArgumentException("El valor por día no puede ser negativo.");
        } else {
            this.diasTrabajados = diasTrabajados;
            this.valorDia = valorDia;
        }
    }

    public float calcularSalarioBruto() {
        float pagoDias = (float)this.diasTrabajados * this.valorDia;
        return pagoDias + this.calcularBonificacionCategoria();
    }
}
